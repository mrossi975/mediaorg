package net.thorhammer.mediaorg.tasks;

public interface TaskExecution {

    TaskExecutionState getCurrentState();

    int getCurrentProgressPercent();

    TaskExecutionResult getExecutionResult();

}
