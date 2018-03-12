package de.toberkoe.fluentassertions.api.numbers;

import de.toberkoe.fluentassertions.api.Assertions;

/**
 * {@code Double} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Double)}.
 *
 * @author t.bertram-koehler
 */
public class DoubleAssert extends NumberAssert<DoubleAssert, Double> {

    public DoubleAssert(Double value) {
        super(value);
    }

}