package de.toberkoe.fluentassertions.api.assertions;

/**
 * {@code Double} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Double)}.
 *
 * @author t.bertram-koehler
 */
public class DoubleAssert extends NumberAssert<DoubleAssert, Double> {

    protected DoubleAssert(Double value) {
        super(value);
    }

}