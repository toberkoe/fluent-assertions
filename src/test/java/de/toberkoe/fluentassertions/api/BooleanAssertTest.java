package de.toberkoe.fluentassertions.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BooleanAssertTest {

    @Test
    void testIsTrue() {
        Assertions.assertThat(true).isTrue();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(false).isTrue());
    }

    @Test
    void testIsFalse() {
        Assertions.assertThat(false).isFalse();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(true).isFalse());
    }
}