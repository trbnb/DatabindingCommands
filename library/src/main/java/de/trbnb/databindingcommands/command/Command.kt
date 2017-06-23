package de.trbnb.databindingcommands.command

import android.databinding.Bindable
import android.databinding.Observable

/**
 * The basic contract for command implementations.
 *
 * @param P The parameter type for invocation. An instance of this has to be passed for invocation.
 * @param R The return type for invocation. An instance of this has to be returned from [invoke].
 */
interface Command<in P, out R> : Observable {

    /**
     * Determines whether this Command is enabled or not.
     *
     * @return Returns `true` if this Command is enabled, otherwise `false`.
     */
    @get:Bindable
    val isEnabled: Boolean

    /**
     * Invokes the Command.
     *
     * If [isEnabled] returns `false` a [de.trbnb.databindingcommands.DisabledCommandInvocationException]
     * will be thrown.
     *
     * @param parameter A parameter instance for an invocation.
     * @return A return type instance.
     */
    operator fun invoke(parameter: P): R

    /**
     * Invokes the Command only if [isEnabled] equals `true`.
     *
     * @param parameter A parameter instance for an invocation.
     * @return A return type instance if [isEnabled] equals `true` before invocation, otherwise `null`.
     */
    fun invokeSafely(parameter: P): R? {
        return if (isEnabled) invoke(parameter) else null
    }
}
