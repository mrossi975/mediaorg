package net.thorhammer.mediaorg.tasks;

public class TaskExecutionImpl implements TaskExecution {

    private final TaskExecutionState currentState;
    private final int progressPercent;
    private final TaskExecutionResult executionResult;

    public TaskExecutionImpl(TaskExecutionState currentState, int progressPercent, TaskExecutionResult executionResult) {
        super();
        this.currentState = currentState;
        this.progressPercent = progressPercent;
        this.executionResult = executionResult;
    }

    @Override
    public TaskExecutionState getCurrentState() {
        return this.currentState;
    }

    @Override
    public int getCurrentProgressPercent() {
        return this.progressPercent;
    }

    @Override
    public TaskExecutionResult getExecutionResult() {
        return executionResult;
    }

}
