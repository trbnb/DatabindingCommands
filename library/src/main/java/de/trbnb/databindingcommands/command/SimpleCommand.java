package de.trbnb.databindingcommands.command;

public class SimpleCommand implements Command {

    private boolean isEnabled;
    protected Runnable action;

    private EnabledChangedListener enabledChangedListener;

    public SimpleCommand(Runnable action) {
        this(action, true);
    }

    public SimpleCommand(Runnable action, boolean isEnabled) {
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
        action.run();
    }

    @Override
    public void setEnabledChangedListener(EnabledChangedListener listener) {
        this.enabledChangedListener = listener;
    }
}
