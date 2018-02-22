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

}