package de.trbnb.databindingcommands.command;

/**
 * The basic contract for command implementations.
 */
public interface Command {

    /**
     * Determines whether this Command is enabled or not.
     * If it is not {@code execute} will have no effect.
     *
     * @return Returns {@code true} if this Command is enabled, otherwise {@code false}.
     */
    boolean isEnabled();

    /**
     * Executes the command.
     *
     * This method does nothing if this Command is not enabled.
     */
    void execute();

    /**
     * Sets a listener that will be called if the result of {@code isEnabled} might have changed.
     *
     * @param listener The new listener.
     */
    void setEnabledChangedListener(EnabledChangedListener listener);
}
