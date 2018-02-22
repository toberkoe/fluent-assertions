package de.toberkoe.fluentassertions.api;

/**
 * {@code Float} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Float)}.
 *
 * @author t.bertram-koehler
 */
public class FloatAssert extends NumberAssert<FloatAssert, Float> {

    protected FloatAssert(Float value) {
        super(value);
    }

}