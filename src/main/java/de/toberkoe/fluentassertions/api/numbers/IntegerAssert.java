package de.toberkoe.fluentassertions.api.numbers;

import de.toberkoe.fluentassertions.api.Assertions;

/**
 * {@code Integer} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Integer)}.
 *
 * @author t.bertram-koehler
 */
public class IntegerAssert extends NumberAssert<IntegerAssert, Integer> {

    public IntegerAssert(Integer value) {
        super(value);
    }
}