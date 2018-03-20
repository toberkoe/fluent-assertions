package de.toberkoe.fluentassertions.api.date;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LocalTimeAssertTest {

    private LocalTime now = LocalTime.now();
    private LocalTime before = now.minusHours(2);
    private LocalTime after = now.plusHours(2);

    @Test
    void isBefore() {
        assertThat(before).isBefore(now);
        assertThrows(AssertionError.class, () -> assertThat(now).isBefore(now));
        assertThrows(AssertionError.class, () -> assertThat(after).isBefore(now));
    }

    @Test
    void isAfter() {
        assertThat(after).isAfter(now);
        assertThrows(AssertionError.class, () -> assertThat(now).isAfter(now));
        assertThrows(AssertionError.class, () -> assertThat(before).isAfter(now));
    }

    @Test
    void isInPast() {
        assertThat(before).isInPast();
        assertThrows(AssertionError.class, () -> assertThat(after).isInPast());
    }

    @Test
    void isInFuture() {
        assertThat(after).isInFuture();
        assertThrows(AssertionError.class, () -> assertThat(now).isInFuture());
        assertThrows(AssertionError.class, () -> assertThat(before).isInFuture());
    }

    @Test
    void isNull() {
        assertThat((LocalTime) null).isNull();
    }

    @Test
    void isNotNull() {
        assertThat(now).isNotNull();
    }

    @Test
    void isEqualTo() {
        assertThat(now).isEqualTo(now);
    }

    @Test
    void isNotEqualTo() {
        assertThat(now).isNotEqualTo(before);
    }

    @Test
    void isSameAs() {
        assertThat(now).isSameAs(now);
    }

    @Test
    void isNotSameAs() {
        assertThat(now).isNotSameAs(before);
    }

    @Test
    void isInstanceOf() {
        assertThat(now).isInstanceOf(LocalTime.class);
    }

    @Test
    void isNotInstanceOf() {
        assertThat(now).isNotInstanceOf(String.class);
    }

    @Test
    void isInstanceOfAny() {
        assertThat(now).isInstanceOfAny(String.class, LocalTime.class);
    }

    @Test
    void isNotInstanceOfAny() {
        assertThat(now).isNotInstanceOfAny(String.class, Integer.class);
    }

}