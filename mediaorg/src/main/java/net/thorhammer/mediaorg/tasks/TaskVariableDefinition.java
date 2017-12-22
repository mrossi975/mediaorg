package net.thorhammer.mediaorg.tasks;

public interface TaskVariableDefinition extends WithNameAndDescription {

    @Override
    String getDescription();

    @Override
    String getName();


}
