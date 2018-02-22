package de.toberkoe.fluentassertions.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerAssertTest {

    @Test
    void testIsZero() {
        assertThrows(AssertionError.class, () -> Assertions.assertThat(- 1).isZero());
        Assertions.assertThat(0).isZero();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(1).isZero());
    }

    @Test
    void testIsNegative() {
        Assertions.assertThat(- 1).isNegative();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(0).isNegative());
        assertThrows(AssertionError.class, () -> Assertions.assertThat(1).isNegative());
    }

    @Test
    void testIsPositive() {
        assertThrows(AssertionError.class, () -> Assertions.assertThat(- 1).isPositive());
        assertThrows(AssertionError.class, () -> Assertions.assertThat(0).isPositive());
        Assertions.assertThat(1).isPositive();
    }

    @Test
    void testIsLessThan() {
        Assertions.assertThat(5).isLessThan(10);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(5).isLessThan(5));
        assertThrows(AssertionError.class, () -> Assertions.assertThat(5).isLessThan(0));
    }

    @Test
    void testIsGreaterThan() {
        Assertions.assertThat(10).isGreaterThan(5);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(5).isGreaterThan(5));
        assertThrows(AssertionError.class, () -> Assertions.assertThat(0).isGreaterThan(5));
    }

    @Test
    void testIsEqualTo() {
        Assertions.assertThat(10).isEqualTo(10);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(5).isEqualTo(10));
    }

    @Test
    void testIsNotEqualTo() {
        Assertions.assertThat(10).isNotEqualTo(1);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(5).isNotEqualTo(5));
    }

    @Test
    void testIsLessThanOrEqualTo() {
        Assertions.assertThat(10).isLessThanOrEqualTo(10);
        Assertions.assertThat(10).isLessThanOrEqualTo(11);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(5).isLessThanOrEqualTo(4));
    }

    @Test
    void testIsGreaterThanOrEqualTo() {
        Assertions.assertThat(10).isGreaterThanOrEqualTo(10);
        Assertions.assertThat(10).isGreaterThanOrEqualTo(9);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(4).isGreaterThanOrEqualTo(5));
    }



}