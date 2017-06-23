package de.trbnb.databindingcommands.command

/**
 * A [Command] implementation that can simply be set as en-/disabled with a boolean value.
 *
 * @param action The initial action that will be run when the Command is executed.
 * @param isEnabled Has to be `true` if this Command should be enabled, otherwise `false`.
 */
open class SimpleCommand<in P, out R>(isEnabled: Boolean = true, action: (P) -> R) : BaseCommandImpl<P, R>(action) {

    override var isEnabled: Boolean = isEnabled
        set(value) {
            field = value
            triggerEnabledChangedListener()
        }

}
