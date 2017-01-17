package de.trbnb.databindingcommands.command;

import android.support.annotation.NonNull;

import de.trbnb.databindingcommands.util.Predicate;

/**
 * A {@link Command} that determines if it is enabled via a {@link Predicate}.
 * This Predicate, or Rule, is set during initialization.
 *
 * The Predicates result will be cached. A refresh can be triggered by calling {@code onEnabledChanged}.
 */
public final class RuleCommand extends BaseCommandImpl {

    private final Predicate enabledRule;

    private boolean cachedEnabledRuleResult;

    /**
     * Creates a new RuleCommand.
     *
     * @param action The initial action that will be run when the Command is executed.
     * @param enabledRule The initial rule that determines if this Command is enabled.
     */
    public RuleCommand(Runnable action, @NonNull Predicate enabledRule) {
        super(action);

        this.enabledRule = enabledRule;
        evaluateEnabledRuleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEnabled() {
        return cachedEnabledRuleResult;
    }

    /**
     * This method has to be called when the result of the rule might have changed.
     */
    public void onEnabledChanged(){
        evaluateEnabledRuleResult();
    }

    private void evaluateEnabledRuleResult(){
        cachedEnabledRuleResult = enabledRule.run();

        triggerEnabledChangedListener();
    }
}
