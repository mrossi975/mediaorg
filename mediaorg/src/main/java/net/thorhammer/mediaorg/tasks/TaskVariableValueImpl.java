package net.thorhammer.mediaorg.tasks;

public class TaskVariableValueImpl implements TaskVariableValue {

    private final String value;
    private final TaskVariableDefinition definition;

    public TaskVariableValueImpl(String value, TaskVariableDefinition definition) {
        super();
        this.value = value;
        this.definition = definition;
    }

    @Override
    public TaskVariableDefinition getDefinition() {
        return this.definition;
    }

    @Override
    public String getValue() {
        return this.value;
    }

}
