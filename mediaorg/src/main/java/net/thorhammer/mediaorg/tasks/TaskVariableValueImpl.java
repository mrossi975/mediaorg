package net.thorhammer.mediaorg.tasks;

public class TaskVariableValueImpl<T> implements TaskVariableValue<T> {

    private final T value;
    private final TaskVariableDefinition<T> definition;

    public TaskVariableValueImpl(T value, TaskVariableDefinition<T> definition) {
        super();
        this.value = value;
        this.definition = definition;
    }

    @Override
    public TaskVariableDefinition<T> getDefinition() {
        return this.definition;
    }

    @Override
    public T getValue() {
        return this.value;
    }

}
