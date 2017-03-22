package de.trbnb.databindingcommands.command;

import android.content.Context;
import android.databinding.Bindable;
import android.databinding.Observable;

/**
 * The basic contract for command implementations.
 */
public interface Command extends Observable {

    /**
     * Determines whether this Command is enabled or not.
     * If it is not {@code execute} will have no effect.
     *
     * @return Returns {@code true} if this Command is enabled, otherwise {@code false}.
     */
    @Bindable
    boolean isEnabled();

    /**
     * Executes the command.
     *
     * This method does nothing if this Command is not enabled.
     *
     * @param context The context of the view that executes this Command.
     */
    void execute(Context context);
}
