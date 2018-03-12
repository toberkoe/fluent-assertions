package de.toberkoe.fluentassertions.api.numbers;

import de.toberkoe.fluentassertions.api.Assertions;

/**
 * {@code Float} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Float)}.
 *
 * @author t.bertram-koehler
 */
public class FloatAssert extends NumberAssert<FloatAssert, Float> {

    public FloatAssert(Float value) {
        super(value);
    }

}