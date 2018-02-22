package de.toberkoe.fluentassertions.api;

/**
 * {@code Integer} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Integer)}.
 *
 * @author t.bertram-koehler
 */
public class IntegerAssert extends NumberAssert<IntegerAssert, Integer> {

    protected IntegerAssert(Integer value) {
        super(value);
    }
}