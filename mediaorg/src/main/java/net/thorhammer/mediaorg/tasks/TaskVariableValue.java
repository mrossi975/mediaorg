package net.thorhammer.mediaorg.tasks;

public interface TaskVariableValue<T> {
    
    TaskVariableDefinition<T> getDefinition();

    T getValue();

}
