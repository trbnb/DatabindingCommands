package de.trbnb.databindingcommands.command;

import android.content.Context;

import de.trbnb.databindingcommands.functions.Action;

/**
 * A {@link Command} implementation that can simply be set as en-/disabled with a boolean value.
 */
public class SimpleCommand extends BaseCommandImpl {

    private boolean isEnabled;

    /**
     * Creates a new, enabled SimpleCommand.
     * The initial enabled-state can be set via the {@code isEnabled} argument.
     *
     * @param action The initial action that will be run when the Command is executed.
     */
    public SimpleCommand(Action<Context> action) {
        this(action, true);
    }

    /**
     * Creates a new SimpleCommand.
     * The initial enabled-state can be set via the {@code isEnabled} argument.
     *
     * @param action The initial action that will be run when the Command is executed.
     * @param isEnabled Has to be {@code true} if this Command should be enabled,
     *                  otherwise {@code false}.
     */
    public SimpleCommand(Action<Context> action, boolean isEnabled) {
        super(action);

        this.isEnabled = isEnabled;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean isEnabled() {
        return isEnabled;
    }

    /**
     * Set the enabled-state.
     *
     * @param enabled Has to be {@code true} if this Command should be enabled,
     *                otherwise {@code false}.
     */
    public final void setEnabled(boolean enabled) {
        isEnabled = enabled;
        triggerEnabledChangedListener();
    }
}
