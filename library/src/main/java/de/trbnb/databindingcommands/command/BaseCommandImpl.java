package de.trbnb.databindingcommands.command;

import android.content.Context;
import android.databinding.BaseObservable;

import de.trbnb.databindingcommands.BR;
import de.trbnb.databindingcommands.functions.Action;

/**
 * Base class for standard {@link Command} implementations.
 *
 * Even though all derivatives of this class have to set a {@link Runnable} as action during
 * initialization it still is mutable, meaning that the action can be changed to something
 * different after initialization.
 *
 * An implementation of the enabled-state is not given.
 */
@SuppressWarnings("WeakerAccess")
abstract class BaseCommandImpl extends BaseObservable implements Command {

    private Action<Context> action;

    /**
     * @param action The initial action that will be run when the Command is executed.
     */
    protected BaseCommandImpl(Action<Context> action){
        setAction(action);
    }

    /**
     * Runs the action if this Command is enabled.
     *
     * @throws IllegalStateException If no action was set.
     */
    @Override
    public final void execute(Context context) {
        if(!isEnabled()){
            return;
        }

        if(action == null){
            throw new IllegalStateException("Action is null on Command execution.");
        }

        action.invoke(context);
    }

    /**
     * This method should be called when the enabled-state might have changed.
     */
    protected final void triggerEnabledChangedListener(){
        notifyPropertyChanged(BR.enabled);
    }

    /**
     * Sets a new action to be run when this Command is executed.
     *
     * @param action The new action.
     */
    public final void setAction(Action<Context> action) {
        this.action = action;
    }
}
