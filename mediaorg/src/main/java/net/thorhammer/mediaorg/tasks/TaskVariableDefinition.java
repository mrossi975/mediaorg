package net.thorhammer.mediaorg.tasks;

public interface TaskVariableDefinition<T> extends WithNameAndDescription {

    @Override
    String getDescription();

    @Override
    String getName();

    Class<T> getValueClass();


}
