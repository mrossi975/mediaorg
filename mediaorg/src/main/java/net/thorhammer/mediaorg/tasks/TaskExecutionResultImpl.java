package net.thorhammer.mediaorg.tasks;

import java.util.Collection;

public class TaskExecutionResultImpl implements TaskExecutionResult {

    private final boolean successful;
    private final String msg;
    private final Collection<TaskVariableValue> values;

    public TaskExecutionResultImpl(boolean successful, String msg, Collection<TaskVariableValue> values) {
        this.successful = successful;
        this.msg = msg;
        this.values = values;
    }

    @Override
    public boolean wasSuccessfull() {
        return this.successful;
    }

    @Override
    public String getExecutionReturnMessage() {
        return this.msg;
    }

    @Override
    public Collection<TaskVariableValue> getExecutionVariables() {
        return this.values;
    }

}
