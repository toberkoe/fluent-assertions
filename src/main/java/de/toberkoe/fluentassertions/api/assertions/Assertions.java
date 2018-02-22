package de.toberkoe.fluentassertions.api.assertions;

import java.math.BigDecimal;

/**
 * Factory class for type-specific assertions.
 *
 * @author t.bertram-koehler
 */
public class Assertions {

    private Assertions() {}

    /**
     * Creates an instance of {@link StringAssert}.
     *
     * @param string the value to be asserted
     * @return instance of assertion object
     */
    public static StringAssert assertThat(String string) {
        return new StringAssert(string);
    }

    /**
     * Creates an instance of {@link IntegerAssert}.
     *
     * @param number the value to be asserted
     * @return instance of assertion object
     */
    public static IntegerAssert assertThat(Integer number) {
        return new IntegerAssert(number);
    }

    /**
     * Creates an instance of {@link BigDecimalAssert}.
     *
     * @param number the value to be asserted
     * @return instance of assertion object
     */
    public static BigDecimalAssert assertThat(BigDecimal number) {
        return new BigDecimalAssert(number);
    }

    /**
     * Creates an instance of {@link DoubleAssert}.
     *
     * @param number the value to be asserted
     * @return instance of assertion object
     */
    public static DoubleAssert assertThat(Double number) {
        return new DoubleAssert(number);
    }
}
