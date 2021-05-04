package org.automation.task.core.enums;

public enum CheckboxState {
    CHECKED,
    UNCHECKED;

    @Override
    public String toString() {
        return name().toLowerCase();
    }

    public boolean toValue() {
        return this == CHECKED;
    }

    public CheckboxState opposite() {
        return this == CHECKED ? UNCHECKED : CHECKED;
    }
}
