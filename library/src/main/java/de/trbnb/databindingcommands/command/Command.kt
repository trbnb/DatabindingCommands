package de.trbnb.databindingcommands.command

/**
 * The basic contract for command implementations.
 *
 * @param P The parameter type for invocation. An instance of this has to be passed for invocation.
 * @param R The return type for invocation. An instance of this has to be returned from [invoke].
 */
interface Command<in P, out R> {

    /**
     * Determines whether this Command is enabled or not.
     *
     * @return Returns `true` if this Command is enabled, otherwise `false`.
     */
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

    /**
     * Adds a listener that is notified when the value of [isEnabled] might have changed.
     */
    fun addEnabledListener(listener: (Boolean) -> Unit)

    /**
     * Removes a listener that is used for listening to changes to [isEnabled].
     * A listener that is passed to this method will not be notified anymore.
     */
    fun removeEnabledListener(listener: (Boolean) -> Unit)

    /**
     * Removes all listeners that are used for listening to changes to [isEnabled].
     * No previously added listeners will be notified anymore.
     */
    fun clearEnabledListeners()
}
