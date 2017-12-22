package net.thorhammer.mediaorg.tasks;

public class TaskVariableDefinitionImpl<T> implements TaskVariableDefinition<T> {
    private final String name;
    private final String description;
    private final Class<T> valueClass;

    public TaskVariableDefinitionImpl(String name, String description, Class<T> valueClass) {
        this.name = name;
        this.description = description;
        this.valueClass = valueClass;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class<T> getValueClass() {
        return this.valueClass;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((valueClass == null) ? 0 : valueClass.getName().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TaskVariableDefinitionImpl<?> other = (TaskVariableDefinitionImpl<?>) obj;
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (valueClass == null) {
            if (other.valueClass != null) {
                return false;
            }
        } else if (!valueClass.getName().equals(other.valueClass.getName())) {
            return false;
        }
        return true;
    }


}
