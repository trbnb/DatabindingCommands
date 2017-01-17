package de.trbnb.databindingcommands.command;

import android.support.annotation.NonNull;

public class SimpleCommand implements Command {

    private boolean isEnabled;
    protected Runnable action;

    private EnabledChangedListener enabledChangedListener;

    public SimpleCommand(@NonNull Runnable action) {
        this(action, true);
    }

    public SimpleCommand(@NonNull Runnable action, boolean isEnabled) {
        this.action = action;
        this.isEnabled = isEnabled;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
        enabledChangedListener.onEnabledChanged(enabled);
    }

    @Override
    public void execute() {
        if(!isEnabled){
            return;
        }

        if(action == null){
            throw new IllegalStateException("Action is null on Command execution.");
        }

        action.run();
    }

    @Override
    public void setEnabledChangedListener(EnabledChangedListener listener) {
        this.enabledChangedListener = listener;
    }
}
