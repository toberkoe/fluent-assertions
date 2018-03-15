package de.toberkoe.fluentassertions.api.numbers;

import org.junit.jupiter.api.Test;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LongAssertTest {

    private Long zero = 0L;
    private Long positive = 1L;
    private Long negative = -1L;

    @Test
    void testIsZero() {
        assertThrows(AssertionError.class, () -> assertThat(negative).isZero());
        assertThat(zero).isZero();
        assertThrows(AssertionError.class, () -> assertThat(positive).isZero());
    }

    @Test
    void testIsNotZero() {
        assertThat(positive).isNotZero();
        assertThrows(AssertionError.class, () -> assertThat(zero).isNotZero());
    }

    @Test
    void testIsNegative() {
        assertThat(negative).isNegative();
        assertThrows(AssertionError.class, () -> assertThat(zero).isNegative());
        assertThrows(AssertionError.class, () -> assertThat(positive).isNegative());
    }

    @Test
    void testIsPositive() {
        assertThrows(AssertionError.class, () -> assertThat(negative).isPositive());
        assertThrows(AssertionError.class, () -> assertThat(zero).isPositive());
        assertThat(positive).isPositive();
    }

    @Test
    void testIsLessThan() {
        assertThat(negative).isLessThan(positive);
        assertThrows(AssertionError.class, () -> assertThat(positive).isLessThan(positive));
        assertThrows(AssertionError.class, () -> assertThat(positive).isLessThan(zero));
    }

    @Test
    void testIsGreaterThan() {
        assertThat(positive).isGreaterThan(negative);
        assertThrows(AssertionError.class, () -> assertThat(zero).isGreaterThan(zero));
        assertThrows(AssertionError.class, () -> assertThat(zero).isGreaterThan(positive));
    }

    @Test
    void testIsEqualTo() {
        assertThat(positive).isEqualTo(positive);
        assertThrows(AssertionError.class, () -> assertThat(negative).isEqualTo(positive));
    }

    @Test
    void testIsNotEqualTo() {
        assertThat(positive).isNotEqualTo(negative);
        assertThrows(AssertionError.class, () -> assertThat(zero).isNotEqualTo(zero));
    }

    @Test
    void testIsLessThanOrEqualTo() {
        assertThat(zero).isLessThanOrEqualTo(zero);
        assertThat(zero).isLessThanOrEqualTo(positive);
        assertThrows(AssertionError.class, () -> assertThat(positive).isLessThanOrEqualTo(zero));
    }

    @Test
    void testIsGreaterThanOrEqualTo() {
        assertThat(positive).isGreaterThanOrEqualTo(positive);
        assertThat(positive).isGreaterThanOrEqualTo(zero);
        assertThrows(AssertionError.class, () -> assertThat(negative).isGreaterThanOrEqualTo(positive));
    }


}