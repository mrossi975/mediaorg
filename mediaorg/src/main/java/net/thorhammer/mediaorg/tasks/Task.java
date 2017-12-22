package net.thorhammer.mediaorg.tasks;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Consumer;

public interface Task extends WithNameAndDescription {

    Collection<TaskVariableDefinition> getVariablesProduced();
    
    Collection<TaskVariableDefinition> getRequiredInputVariables();

    void execute(Collection<TaskVariableValue> variables, Consumer<TaskExecution> executionResultConsumer);

    default boolean areRequiredVariablesAvailable(Collection<TaskVariableValue> values) {
        return values != null && getRequiredInputVariables().stream().allMatch(iv -> values.stream().anyMatch(v -> v.getDefinition().equals(iv)));
    }

    default TaskVariableValue getInputVariable(TaskVariableDefinition varDef, Collection<TaskVariableValue> values) {
        return values.stream().filter(v -> v.getDefinition().equals(varDef)).findFirst().get();
    }

    default TaskExecutionResult failedMissingInputVariables() {
        return new TaskExecutionResultImpl(false, "Missing input variables", Collections.emptyList());
    }

    default TaskExecution failWith(TaskExecutionResult res) {
        return new TaskExecutionImpl(TaskExecutionState.FAILED, -1, res);
    }

    default TaskExecutionResult failedWithException(Exception ex) {
        return new TaskExecutionResultImpl(false, "Exception during execution: " + ex.getMessage(), Collections.emptyList());
    }
}
