package de.trbnb.databindingcommands.command

import android.databinding.BaseObservable
import de.trbnb.databindingcommands.BR
import de.trbnb.databindingcommands.DisabledCommandInvocationException

/**
 * Base class for standard [Command] implementations.

 * An implementation of the [Command.isEnabled] is not given.
 *
 * @param action The initial action that will be run when the Command is executed.
 */
abstract class BaseCommandImpl<in P, out R>(val action: (P) -> R) : BaseObservable(), Command<P, R> {

    override fun invoke(parameter: P): R {
        if(!isEnabled){
            throw DisabledCommandInvocationException()
        }

        return action(parameter)
    }

    /**
     * This method should be called when the result of [isEnabled] might have changed.
     */
    protected fun triggerEnabledChangedListener() {
        notifyPropertyChanged(BR.enabled)
    }
}
