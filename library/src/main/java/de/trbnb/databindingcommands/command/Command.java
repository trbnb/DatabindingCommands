package de.trbnb.databindingcommands.command;

public interface Command {

    boolean isEnabled();
    void setEnabled(boolean enabled);

    void execute();

    void setEnabledChangedListener(EnabledChangedListener listener);
}
