package de.toberkoe.fluentassertions.api;

import de.toberkoe.fluentassertions.api.assertions.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerAssertTest {

    //isLessThan
    //isGreaterThan
    //isLessThanOrEqualTo
    //isGreaterThanOrEqualTo
    //isEqualTo
    //isNotEqualTo

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



}