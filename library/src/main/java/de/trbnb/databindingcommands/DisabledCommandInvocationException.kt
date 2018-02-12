package de.trbnb.databindingcommands

import de.trbnb.databindingcommands.command.Command

/**
 * Exception that will only be thrown if [Command.invoke] has been called even though
 * [Command.isEnabled] was `false` at the same time.
 */
class DisabledCommandInvocationException : RuntimeException()
