package de.toberkoe.fluentassertions.api.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LocalDateAssertTest {

    private LocalDate now = LocalDate.now();
    private LocalDate yesterday = LocalDate.now().minusDays(1);
    private LocalDate tomorrow = LocalDate.now().plusDays(1);

    @Test
    void isBefore() {
        assertThat(yesterday).isBefore(now);
        assertThrows(AssertionError.class, () -> assertThat(now).isBefore(now));
        assertThrows(AssertionError.class, () -> assertThat(tomorrow).isBefore(now));
    }

    @Test
    void isAfter() {
        assertThat(tomorrow).isAfter(now);
        assertThrows(AssertionError.class, () -> assertThat(now).isAfter(now));
        assertThrows(AssertionError.class, () -> assertThat(yesterday).isAfter(now));
    }

    @Test
    void isInPast() {
        assertThat(yesterday).isInPast();
        assertThrows(AssertionError.class, () -> assertThat(now).isInPast());
        assertThrows(AssertionError.class, () -> assertThat(tomorrow).isInPast());
    }

    @Test
    void isInFuture() {
        assertThat(tomorrow).isInFuture();
        assertThrows(AssertionError.class, () -> assertThat(now).isInFuture());
        assertThrows(AssertionError.class, () -> assertThat(yesterday).isInFuture());
    }

    @Test
    void isToday() {
        assertThat(now).isToday();
        assertThrows(AssertionError.class, () -> assertThat(yesterday).isToday());
        assertThrows(AssertionError.class, () -> assertThat(tomorrow).isToday());
    }

    @Test
    void isYesterday() {
        assertThat(yesterday).isYesterday();
        assertThrows(AssertionError.class, () -> assertThat(now).isYesterday());
        assertThrows(AssertionError.class, () -> assertThat(tomorrow).isYesterday());
    }

    @Test
    void isTomorrow() {
        assertThat(tomorrow).isTomorrow();
        assertThrows(AssertionError.class, () -> assertThat(now).isTomorrow());
        assertThrows(AssertionError.class, () -> assertThat(yesterday).isTomorrow());
    }

    @Test
    void isNull() {
        assertThat((LocalDate) null).isNull();
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
        assertThat(now).isNotEqualTo(yesterday);
    }

    @Test
    void isSameAs() {
        assertThat(now).isSameAs(now);
    }

    @Test
    void isNotSameAs() {
        assertThat(now).isNotSameAs(yesterday);
    }

    @Test
    void isInstanceOf() {
        assertThat(now).isInstanceOf(LocalDate.class);
    }

    @Test
    void isNotInstanceOf() {
        assertThat(now).isNotInstanceOf(String.class);
    }

    @Test
    void isInstanceOfAny() {
        assertThat(now).isInstanceOfAny(String.class, LocalDate.class);
    }

    @Test
    void isNotInstanceOfAny() {
        assertThat(now).isNotInstanceOfAny(String.class, Integer.class);
    }
}