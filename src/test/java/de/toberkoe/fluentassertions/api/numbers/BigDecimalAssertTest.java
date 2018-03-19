package de.toberkoe.fluentassertions.api.numbers;

import de.toberkoe.fluentassertions.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BigDecimalAssertTest {

    private BigDecimal zero = BigDecimal.ZERO;
    private BigDecimal positive = BigDecimal.ONE;
    private BigDecimal negative = BigDecimal.ONE.negate();

    @Test
    void testIsZero() {
        assertThrows(AssertionError.class, () -> Assertions.assertThat(negative).isZero());
        Assertions.assertThat(zero).isZero();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(positive).isZero());
    }

    @Test
    void testIsNegative() {
        Assertions.assertThat(negative).isNegative();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(zero).isNegative());
        assertThrows(AssertionError.class, () -> Assertions.assertThat(positive).isNegative());
    }

    @Test
    void testIsPositive() {
        assertThrows(AssertionError.class, () -> Assertions.assertThat(negative).isPositive());
        assertThrows(AssertionError.class, () -> Assertions.assertThat(zero).isPositive());
        Assertions.assertThat(positive).isPositive();
    }

    @Test
    void testIsLessThan() {
        Assertions.assertThat(negative).isLessThan(positive);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(positive).isLessThan(positive));
        assertThrows(AssertionError.class, () -> Assertions.assertThat(positive).isLessThan(zero));
    }

    @Test
    void testIsGreaterThan() {
        Assertions.assertThat(positive).isGreaterThan(negative);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(zero).isGreaterThan(zero));
        assertThrows(AssertionError.class, () -> Assertions.assertThat(zero).isGreaterThan(positive));
    }

    @Test
    void testIsEqualTo() {
        Assertions.assertThat(positive).isEqualTo(positive);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(negative).isEqualTo(positive));
    }

    @Test
    void testIsNotEqualTo() {
        Assertions.assertThat(positive).isNotEqualTo(negative);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(zero).isNotEqualTo(zero));
    }

    @Test
    void testIsLessThanOrEqualTo() {
        Assertions.assertThat(zero).isLessThanOrEqualTo(zero);
        Assertions.assertThat(zero).isLessThanOrEqualTo(positive);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(positive).isLessThanOrEqualTo(zero));
    }

    @Test
    void testIsGreaterThanOrEqualTo() {
        Assertions.assertThat(positive).isGreaterThanOrEqualTo(positive);
        Assertions.assertThat(positive).isGreaterThanOrEqualTo(zero);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(negative).isGreaterThanOrEqualTo(positive));
    }

    @Test
    void testIsEqualToString() {
        BigDecimal meaningOfLife = BigDecimal.ONE.add(BigDecimal.valueOf(20)).add(BigDecimal.valueOf(21.0)).add(BigDecimal.valueOf(0.10));
        Assertions.assertThat(meaningOfLife).isEqualTo("42.1");
        assertThrows(AssertionError.class, () -> Assertions.assertThat(meaningOfLife).isEqualTo("Text"));
    }



}