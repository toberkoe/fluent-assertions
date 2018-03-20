package de.toberkoe.fluentassertions.api.date;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InstantAssertTest {

    private Instant now = Instant.now();
    private Instant yesterday = Instant.now().minusSeconds(Duration.ofDays(1).toSeconds());
    private Instant tomorrow = Instant.now().plusSeconds(Duration.ofDays(1).toSeconds());

    private Instant before = yesterday;
    private Instant middle = now;
    private Instant after = tomorrow;

    @Test
    void isBefore() {
        assertThat(before).isBefore(middle);
        assertThrows(AssertionError.class, () -> assertThat(middle).isBefore(middle));
        assertThrows(AssertionError.class, () -> assertThat(after).isBefore(middle));
    }

    @Test
    void isAfter() {
        assertThat(after).isAfter(before);
        assertThrows(AssertionError.class, () -> assertThat(middle).isAfter(middle));
        assertThrows(AssertionError.class, () -> assertThat(before).isAfter(middle));
    }

    @Test
    void isInPast() {
        assertThat(yesterday).isInPast();
        assertThrows(AssertionError.class, () -> assertThat(tomorrow).isInPast());
        assertThrows(AssertionError.class, () -> assertThat(Instant.now()).isInPast());
    }

    @Test
    void isInFuture() {
        assertThat(tomorrow).isInFuture();
        assertThrows(AssertionError.class, () -> assertThat(yesterday).isInFuture());
        assertThrows(AssertionError.class, () -> assertThat(now).isInFuture());
    }

    @Test
    void isToday() {
        assertThat(now).isToday();
        assertThrows(AssertionError.class, () -> assertThat(tomorrow).isToday());
        assertThrows(AssertionError.class, () -> assertThat(yesterday).isToday());
    }

    @Test
    void isYesterday() {
        assertThat(yesterday).isYesterday();
        assertThrows(AssertionError.class, () -> assertThat(tomorrow).isYesterday());
        assertThrows(AssertionError.class, () -> assertThat(now).isYesterday());
    }

    @Test
    void isTomorrow() {
        assertThat(tomorrow).isTomorrow();
        assertThrows(AssertionError.class, () -> assertThat(yesterday).isTomorrow());
        assertThrows(AssertionError.class, () -> assertThat(now).isTomorrow());
    }

    @Test
    void isNull() {
        assertThat((Instant) null).isNull();
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
        assertThat(now).isInstanceOf(Instant.class);
    }

    @Test
    void isNotInstanceOf() {
        assertThat(now).isNotInstanceOf(String.class);
    }

    @Test
    void isInstanceOfAny() {
        assertThat(now).isInstanceOfAny(Integer.class, Instant.class);
    }

    @Test
    void isNotInstanceOfAny() {
        assertThat(now).isNotInstanceOfAny(Integer.class, String.class);
    }
}