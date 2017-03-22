package de.trbnb.databindingcommands.command;

import android.content.Context;
import android.support.annotation.NonNull;

import de.trbnb.databindingcommands.functions.Action;
import de.trbnb.databindingcommands.functions.Predicate;

/**
 * A {@link Command} that determines if it is enabled via a {@link Predicate}.
 * This Predicate, or Rule, is set during initialization.
 *
 * The Predicates result will be cached. A refresh can be triggered by calling {@code onEnabledChanged}.
 */
public class RuleCommand extends BaseCommandImpl {

    private final Predicate enabledRule;

    private boolean cachedEnabledRuleResult;

    /**
     * Creates a new RuleCommand.
     *
     * @param action The initial action that will be run when the Command is executed.
     * @param enabledRule The initial rule that determines if this Command is enabled.
     */
    public RuleCommand(Action<Context> action, @NonNull Predicate enabledRule) {
        super(action);

        this.enabledRule = enabledRule;
        evaluateEnabledRuleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean isEnabled() {
        return cachedEnabledRuleResult;
    }

    /**
     * This method has to be called when the result of the rule might have changed.
     */
    public final void onEnabledChanged(){
        evaluateEnabledRuleResult();
    }

    private void evaluateEnabledRuleResult(){
        cachedEnabledRuleResult = enabledRule.run();

        triggerEnabledChangedListener();
    }
}
