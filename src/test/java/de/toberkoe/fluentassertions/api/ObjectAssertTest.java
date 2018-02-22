package de.toberkoe.fluentassertions.api;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ObjectAssertTest {

    @Test
    void testIsNull() {
        Object value = null;
        Assertions.assertThat(value).isNull();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(new Object()).isNull());
    }

    @Test
    void testIsNotNull() {
        Object value = new Object();
        Assertions.assertThat(value).isNotNull();
        assertThrows(AssertionError.class, () -> Assertions.assertThat((Object) null).isNotNull());
    }

    @Test
    void testIsEqualTo() {
        Object first = BigDecimal.valueOf(1000);
        Object second = BigDecimal.valueOf(1000);
        Assertions.assertThat(first).isEqualTo(second);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(first).isEqualTo(""));
    }

    @Test
    void testIsNotEqualTo() {
        Object first = BigDecimal.valueOf(1000);
        Object second = BigDecimal.valueOf(1);
        Assertions.assertThat(first).isNotEqualTo(second);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(first).isNotEqualTo(first));
    }

    @Test
    void testIsSameAs() {
        Object first = BigDecimal.ONE;
        Object second = BigDecimal.ONE;
        Assertions.assertThat(first).isSameAs(second);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(first).isSameAs(BigDecimal.ZERO));
    }

    @Test
    void testIsNotSameAs() {
        Object first = BigDecimal.valueOf(1000);
        Object second = BigDecimal.valueOf(1);
        Assertions.assertThat(first).isNotSameAs(second);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(first).isNotSameAs(first));
    }

    @Test
    void testIsInstanceOf() {
        Assertions.assertThat(new ArrayList<>()).isInstanceOf(List.class);
        assertThrows(AssertionError.class, () -> Assertions.assertThat("").isInstanceOf(BigDecimal.class));
    }

    @Test
    void testIsNotInstanceOf() {
        Assertions.assertThat(new ArrayList<>()).isNotInstanceOf(String.class);
        assertThrows(AssertionError.class, () -> Assertions.assertThat("").isNotInstanceOf(String.class));
    }

    @Test
    void testIsInstanceOfAny() {
        Assertions.assertThat(LocalDate.now()).isInstanceOfAny(String.class, Temporal.class);
        assertThrows(AssertionError.class, () -> Assertions.assertThat("").isInstanceOfAny(Number.class, Date.class));
    }

    @Test
    void testIsNotInstanceOfAny() {
        Assertions.assertThat(LocalDate.now()).isNotInstanceOfAny(String.class, Number.class);
        assertThrows(AssertionError.class, () -> Assertions.assertThat("").isNotInstanceOfAny(String.class, Date.class));
    }

}