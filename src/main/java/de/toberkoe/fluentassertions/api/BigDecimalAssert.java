package de.toberkoe.fluentassertions.api;

import java.math.BigDecimal;

/**
 * {@code BigDecimal} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(BigDecimal)}.
 *
 * @author t.bertram-koehler
 */
public class BigDecimalAssert extends NumberAssert<BigDecimalAssert, BigDecimal> {

    protected BigDecimalAssert(BigDecimal value) {
        super(value);
    }

    public BigDecimalAssert isEqualTo(String valueAsString) {
        try {
            BigDecimal expected = new BigDecimal(valueAsString);
            return isEqualTo(expected);
        } catch (NumberFormatException e) {
            throw error("Given value '%s' cannot be pared as number", valueAsString);
        }
    }

}