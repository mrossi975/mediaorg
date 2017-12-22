package net.thorhammer.mediaorg.mediaorgtasks;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.thorhammer.mediaorg.tasks.Task;
import net.thorhammer.mediaorg.tasks.TaskExecution;
import net.thorhammer.mediaorg.tasks.TaskExecutionImpl;
import net.thorhammer.mediaorg.tasks.TaskExecutionResult;
import net.thorhammer.mediaorg.tasks.TaskExecutionResultImpl;
import net.thorhammer.mediaorg.tasks.TaskExecutionState;
import net.thorhammer.mediaorg.tasks.TaskVariableDefinition;
import net.thorhammer.mediaorg.tasks.TaskVariableDefinitionImpl;
import net.thorhammer.mediaorg.tasks.TaskVariableValue;
import net.thorhammer.mediaorg.tasks.TaskVariableValueImpl;

public class CopyToTarget implements Task {
    private static final Logger LOG = LoggerFactory.getLogger("mediaorg.tasks.CopyToTarget");

    private static final TaskVariableDefinition SOURCE_PATH = new TaskVariableDefinitionImpl("sourcePath", "The fully qualified file path to copy");
    private static final TaskVariableDefinition SOURCE_FILENAME = new TaskVariableDefinitionImpl("sourceFilename", "The name of the file to copy");
    private static final TaskVariableDefinition TARGET_FILENAME = new TaskVariableDefinitionImpl("targetFilename", "The target name of the file to copy");
    private static final TaskVariableDefinition TARGET_PATH = new TaskVariableDefinitionImpl("targetPath", "Path of destination folder");

    private static final TaskVariableDefinition COPY_TIME_MS = new TaskVariableDefinitionImpl("copyTimeMs", "Time taken to copy file over to destination");

    private static final Collection<TaskVariableDefinition> VARIABLES_PRODUCED = Arrays.asList(TARGET_PATH, TARGET_FILENAME, COPY_TIME_MS);
    private static final Collection<TaskVariableDefinition> VARIABLES_CONSUMED = Arrays.asList(SOURCE_PATH, SOURCE_FILENAME, TARGET_PATH, TARGET_FILENAME);

    public CopyToTarget() {
        super();
    }

    @Override
    public String getName() {
        return "CopyToTargetTask";
    }

    @Override
    public String getDescription() {
        return "Copies a file to a destination folder";
    }

    @Override
    public Collection<TaskVariableDefinition> getVariablesProduced() {
        return VARIABLES_PRODUCED;
    }

    @Override
    public Collection<TaskVariableDefinition> getRequiredInputVariables() {
        return VARIABLES_CONSUMED;
    }

    @Override
    public void execute(Collection<TaskVariableValue> variables, Consumer<TaskExecution> executionResultConsumer) {
        long ts0 = System.currentTimeMillis();

        if (!this.areRequiredVariablesAvailable(variables)) {
            executionResultConsumer.accept(failWith(failedMissingInputVariables()));
            return;
        }

        TaskVariableValue sourcePathVar = this.getInputVariable(SOURCE_PATH, variables);
        TaskVariableValue sourceFilename = this.getInputVariable(SOURCE_FILENAME, variables);
        TaskVariableValue targetPathVar = this.getInputVariable(TARGET_PATH, variables);
        TaskVariableValue targetFilename = this.getInputVariable(TARGET_FILENAME, variables);

        try {

            Path sourcePath = Paths.get(sourcePathVar.getValue(), sourceFilename.getValue());
            Path targetPath = Paths.get(targetPathVar.getValue(), targetFilename.getValue());

            Path fullDestinationPath = Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

            TaskVariableValue actualTargetPathVar = new TaskVariableValueImpl(fullDestinationPath.getParent().toString(), TARGET_PATH);
            TaskVariableValue actualTargetFileVar = new TaskVariableValueImpl(fullDestinationPath.getFileName().toString(), TARGET_FILENAME);
            TaskVariableValue copyTimeMs = new TaskVariableValueImpl(Long.valueOf(System.currentTimeMillis() - ts0).toString(), COPY_TIME_MS);

            TaskExecutionResult executionResult = new TaskExecutionResultImpl(true, null, Arrays.asList(actualTargetPathVar, actualTargetFileVar, copyTimeMs));
            TaskExecution te = new TaskExecutionImpl(TaskExecutionState.COMPLETED_SUCCESSFULLY, 100, executionResult);

            executionResultConsumer.accept(te);

        } catch (Exception ex) {
            LOG.error("Exception while attempting to copy {}/{} to {}/{}", sourcePathVar, sourceFilename, targetPathVar, targetFilename, ex);

            executionResultConsumer.accept(failWith(failedWithException(ex)));
            return;
        }
    }

}
