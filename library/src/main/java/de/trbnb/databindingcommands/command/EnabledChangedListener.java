package de.trbnb.databindingcommands.command;

/**
 * Listener interface for listening to changes to the enabled-state of {@link Command}s.
 */
public interface EnabledChangedListener {
    /**
     * Called when the enabled-state of a Command might have changed.
     *
     * @param enabled This is {@code true} if the Command is enabled, otherwise {@code false}.
     */
    void onEnabledChanged(boolean enabled);
}
