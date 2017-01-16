package de.trbnb.databindingcommands.command;

public interface Command {

    boolean isEnabled();

    void execute();

    void setEnabledChangedListener(EnabledChangedListener listener);
}
