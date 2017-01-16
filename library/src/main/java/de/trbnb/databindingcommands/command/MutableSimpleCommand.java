package de.trbnb.databindingcommands.command;

public final class MutableSimpleCommand extends SimpleCommand {

    public MutableSimpleCommand(Runnable action) {
        super(action);
    }

    public MutableSimpleCommand(Runnable action, boolean isEnabled) {
        super(action, isEnabled);
    }

    public void setAction(Runnable action){
        this.action = action;
    }
}
