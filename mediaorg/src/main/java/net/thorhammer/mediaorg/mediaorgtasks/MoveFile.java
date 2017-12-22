package net.thorhammer.mediaorg.mediaorgtasks;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;

import net.thorhammer.mediaorg.tasks.Task;
import net.thorhammer.mediaorg.tasks.TaskExecution;
import net.thorhammer.mediaorg.tasks.TaskExecutionState;
import net.thorhammer.mediaorg.tasks.TaskVariableDefinition;
import net.thorhammer.mediaorg.tasks.TaskVariableDefinitionImpl;
import net.thorhammer.mediaorg.tasks.TaskVariableValue;

public class MoveFile implements Task {

    private static final TaskVariableDefinition<String> SOURCE_PATH = new TaskVariableDefinitionImpl<>(
            "sourcePath",
            "The fully qualified file path to move",
            String.class);
    private static final TaskVariableDefinition<String> SOURCE_FILENAME = new TaskVariableDefinitionImpl<>(
            "sourceFilename",
            "The name of the file to move",
            String.class);
    private static final TaskVariableDefinition<String> TARGET_FILENAME = new TaskVariableDefinitionImpl<>(
            "targetFilename",
            "The target name of the file to move",
            String.class);

    private static final TaskVariableDefinition<String> TARGET_PATH = new TaskVariableDefinitionImpl<>(
            "targetPath",
            "Path of destination folder",
            String.class);

    private static final TaskVariableDefinition<Long> EXECUTION_TIME_MS = new TaskVariableDefinitionImpl<>(
            "executionTimeMs",
            "Time taken to copy file over to destination",
            Long.class);

    private static final Collection<TaskVariableDefinition<?>> VARIABLES_PRODUCED = Arrays.asList(TARGET_PATH, TARGET_FILENAME, EXECUTION_TIME_MS);
    private static final Collection<TaskVariableDefinition<?>> VARIABLES_CONSUMED = Arrays.asList(SOURCE_PATH, SOURCE_FILENAME, TARGET_PATH, TARGET_FILENAME);

    public MoveFile() {
        super();
    }

    @Override
    public String getName() {
        return "MoveFileTask";
    }

    @Override
    public String getDescription() {
        return "Moves a file to a destination folder";
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

        CopyToTarget copyTask = new CopyToTarget();

        copyTask.execute(variables, te -> {
            if (TaskExecutionState.COMPLETED_SUCCESSFULLY.equals(te.getCurrentState())) {
                DeleteFile deleteFileTask = new DeleteFile();
                deleteFileTask.execute(variables, executionResultConsumer);
                return;
            }

            executionResultConsumer.accept(te);
        });

    }

}
