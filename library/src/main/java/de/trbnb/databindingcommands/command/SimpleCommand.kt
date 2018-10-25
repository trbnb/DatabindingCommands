package de.trbnb.databindingcommands.command

/**
 * A [Command] implementation that can simply be set as en-/disabled with a boolean value.
 *
 * @param action The initial action that will be run when the Command is executed.
 * @param isEnabled Has to be `true` if this Command should be enabled, otherwise `false`.
 */
@Deprecated("This library is deprecated and migrated into MvvmBase (https://github.com/trbnb/mvvmbase)")
open class SimpleCommand<out R>(isEnabled: Boolean = true, action: () -> R) : BaseCommandImpl<R>(action) {

    override var isEnabled: Boolean = isEnabled
        set(value) {
            field = value
            triggerEnabledChangedListener()
        }

}
