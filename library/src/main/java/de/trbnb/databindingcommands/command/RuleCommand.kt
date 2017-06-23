package de.trbnb.databindingcommands.command

/**
 * A [Command] that determines if it is enabled via a predicate.
 * This predicate, or "rule", is set during initialization.

 * The predicates result will be cached. A refresh can be triggered by calling `onEnabledChanged`.
 *
 * @param action The initial action that will be run when the Command is executed.
 * @param enabledRule The initial rule that determines if this Command is enabled.
 */
open class RuleCommand<in P, out R>(action: (P) -> R, private val enabledRule: () -> Boolean) : BaseCommandImpl<P, R>(action) {

    override var isEnabled: Boolean = false

    init {
        evaluateEnabledRuleResult()
    }

    /**
     * This method has to be called when the result of the rule might have changed.
     */
    fun onEnabledChanged() {
        evaluateEnabledRuleResult()
    }

    private fun evaluateEnabledRuleResult() {
        isEnabled = enabledRule()

        triggerEnabledChangedListener()
    }
}
