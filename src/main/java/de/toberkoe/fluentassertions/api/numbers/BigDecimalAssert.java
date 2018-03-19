package de.toberkoe.fluentassertions.api.numbers;

import de.toberkoe.fluentassertions.api.Assertions;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * {@code BigDecimal} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(BigDecimal)}.
 *
 * @author t.bertram-koehler
 */
public class BigDecimalAssert extends NumberAssert<BigDecimalAssert, BigDecimal> {

    private static final int SCALE = 12;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    public BigDecimalAssert(BigDecimal value) {
        super(value);
    }

    public BigDecimalAssert isEqualTo(String valueAsString) {
        try {
            BigDecimal actual = value.setScale(SCALE, ROUNDING_MODE);
            BigDecimal expected = new BigDecimal(valueAsString).setScale(SCALE, ROUNDING_MODE);
            return new BigDecimalAssert(actual).isEqualTo(expected);
        } catch (NumberFormatException e) {
            throw error("Given value '%s' cannot be pared as number", valueAsString);
        }
    }

}