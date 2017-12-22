package net.thorhammer.mediaorg.mediaorgtasks;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
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

public class ExtractMetadata implements Task {
    private static final Logger LOG = LoggerFactory.getLogger("mediaorg.tasks.ExtractMetadata");

    private static final TaskVariableDefinition<String> SOURCE_PATH = new TaskVariableDefinitionImpl<>(
            "sourcePath",
            "The fully qualified path of the files from which to extract shooting date",
            String.class);
    
    private static final TaskVariableDefinition<String> SOURCE_FILENAME = new TaskVariableDefinitionImpl<>(
            "sourceFilename",
            "The name of the file from which you want to extract the shooting date",
            String.class);
    
    private static final TaskVariableDefinition<Long> EXECUTION_TIME_MS = new TaskVariableDefinitionImpl<>(
            "executionTimeMs",
            "Time taken to execute task",
            Long.class);

    private static final TaskVariableDefinition<LocalDateTime> SHOOTING_DATETIME = new TaskVariableDefinitionImpl<>(
            "shootingDateTime",
            "Time of shooting of given file",
            LocalDateTime.class);

    private static final Collection<TaskVariableDefinition<?>> VARIABLES_PRODUCED = Arrays.asList(SHOOTING_DATETIME, EXECUTION_TIME_MS);
    
    private static final Collection<TaskVariableDefinition<?>> VARIABLES_CONSUMED = Arrays.asList(SOURCE_PATH, SOURCE_FILENAME);

    public ExtractMetadata() {
        super();
    }

    @Override
    public String getName() {
        return "ObtainShootingTimestamp";
    }

    @Override
    public String getDescription() {
        return "Extracts metadata from a media file";
    }

    @Override
    public Collection<TaskVariableDefinition<?>> getVariablesProduced() {
        return VARIABLES_PRODUCED;
    }

    @Override
    public Collection<TaskVariableDefinition<?>> getRequiredInputVariables() {
        return VARIABLES_CONSUMED;
    }

    @Override
    public void execute(Collection<TaskVariableValue<?>> variables, Consumer<TaskExecution> executionResultConsumer) {
        long ts0 = System.currentTimeMillis();

        if (!this.areRequiredVariablesAvailable(variables)) {
            executionResultConsumer.accept(failWith(failedMissingInputVariables()));
            return;
        }

        TaskVariableValue<String> sourcePathVar = this.getInputVariable(SOURCE_PATH, variables);
        TaskVariableValue<String> sourceFilename = this.getInputVariable(SOURCE_FILENAME, variables);

        try {

            Path sourcePath = Paths.get(sourcePathVar.getValue(), sourceFilename.getValue());

            // TODO use API to get shooting date & other metadata

            TaskVariableValue<Long> executionTimeMs = new TaskVariableValueImpl<>(Long.valueOf(System.currentTimeMillis() - ts0), EXECUTION_TIME_MS);

            TaskExecutionResult executionResult = new TaskExecutionResultImpl(true, null, Arrays.asList(executionTimeMs));
            TaskExecution te = new TaskExecutionImpl(TaskExecutionState.COMPLETED_SUCCESSFULLY, 100, executionResult);

            executionResultConsumer.accept(te);

        } catch (Exception ex) {
            LOG.error("Exception while attempting to extract metadata from {}/{}", sourcePathVar, sourceFilename, ex);

            executionResultConsumer.accept(failWith(failedWithException(ex)));
            return;
        }
    }

}
