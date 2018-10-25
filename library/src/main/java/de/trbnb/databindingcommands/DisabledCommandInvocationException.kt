package de.trbnb.databindingcommands

import de.trbnb.databindingcommands.command.Command

/**
 * Exception that will only be thrown if [Command.invoke] has been called even though
 * [Command.isEnabled] was `false` at the same time.
 */
@Deprecated("This library is deprecated and migrated into MvvmBase (https://github.com/trbnb/mvvmbase)")
class DisabledCommandInvocationException : RuntimeException()
