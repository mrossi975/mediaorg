package net.thorhammer.mediaorg.tasks;

import java.util.Collection;

public interface TaskExecutionResult {

    boolean wasSuccessfull();

    String getExecutionReturnMessage();

    Collection<TaskVariableValue<?>> getExecutionVariables();

}
