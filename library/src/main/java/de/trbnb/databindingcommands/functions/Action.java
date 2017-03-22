package de.trbnb.databindingcommands.functions;

/**
 * A functional interface that haas to be invoked with a parameter and returns nothing.
 * @param <P> Type of the invocation parameter.
 */
public interface Action<P> {
    void invoke(P parameter);
}
