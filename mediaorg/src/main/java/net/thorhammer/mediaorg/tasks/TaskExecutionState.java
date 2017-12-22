package net.thorhammer.mediaorg.tasks;

public enum TaskExecutionState {
    NEW,
    QUEUED,
    INPROGRESS,
    COMPLETED_SUCCESSFULLY,
    FAILED
}
