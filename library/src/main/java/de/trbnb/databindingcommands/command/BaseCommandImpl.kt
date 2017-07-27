package de.trbnb.databindingcommands.command

import de.trbnb.databindingcommands.DisabledCommandInvocationException
import java.lang.ref.WeakReference

/**
 * Base class for standard [Command] implementations.

 * An implementation of the [Command.isEnabled] is not given.
 *
 * @param action The initial action that will be run when the Command is executed.
 */
abstract class BaseCommandImpl<in P, out R>(val action: (P) -> R) : Command<P, R> {

    private val listeners: MutableList<WeakReference<(Boolean) -> Unit>> = mutableListOf()

    override final fun invoke(parameter: P): R {
        if(!isEnabled){
            throw DisabledCommandInvocationException()
        }

        return action(parameter)
    }

    /**
     * This method should be called when the result of [isEnabled] might have changed.
     */
    protected fun triggerEnabledChangedListener() {
        listeners.forEach {
            it.get()?.invoke(isEnabled)
        }
    }

    override fun addEnabledListener(listener: (Boolean) -> Unit) {
        listeners.add(WeakReference(listener))
    }

    override fun removeEnabledListener(listener: (Boolean) -> Unit) {
        listeners.removeAll { it.get() == listener }
    }

    override fun clearEnabledListeners(listener: (Boolean) -> Unit) {
        listeners.clear()
    }


}
