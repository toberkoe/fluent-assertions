package de.toberkoe.fluentassertions.api.date;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DurationAssertTest {

    @Test
    void isPositive() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        assertThat(Duration.between(yesterday, now)).isPositive();
        assertThrows(AssertionError.class, () -> assertThat(Duration.between(now, now)).isPositive());
    }

    @Test
    void isZero() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        assertThat(Duration.between(now, now)).isZero();
        assertThrows(AssertionError.class, () -> assertThat(Duration.between(yesterday, now)).isZero());
    }

    @Test
    void isNegative() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);
        assertThat(Duration.between(now, yesterday)).isNegative();
        assertThrows(AssertionError.class, () -> assertThat(Duration.between(yesterday, now)).isNegative());
    }

    @Test
    void isGreaterThanOrEqualTo() {
        assertThat(Duration.ofDays(1)).isGreaterThanOrEqualTo(Duration.ofHours(24));
        assertThat(Duration.ofDays(1)).isGreaterThanOrEqualTo(Duration.ofHours(23));
        assertThrows(AssertionError.class, () -> assertThat(Duration.ofDays(1)).isGreaterThanOrEqualTo(Duration.ofHours(25)));
    }

    @Test
    void isGreaterThan() {
        assertThat(Duration.ofDays(1)).isGreaterThan(Duration.ofHours(23));
        assertThrows(AssertionError.class, () -> assertThat(Duration.ofDays(1)).isGreaterThan(Duration.ofHours(24)));
    }

    @Test
    void isLowerThan() {
        assertThat(Duration.ofDays(1)).isLowerThan(Duration.ofHours(25));
        assertThrows(AssertionError.class, () -> assertThat(Duration.ofDays(1)).isLowerThan(Duration.ofHours(24)));
    }

    @Test
    void isLowerThanOrEqualTo() {
        assertThat(Duration.ofDays(1)).isLowerThanOrEqualTo(Duration.ofHours(25));
        assertThat(Duration.ofDays(1)).isLowerThanOrEqualTo(Duration.ofHours(24));
        assertThrows(AssertionError.class, () -> assertThat(Duration.ofDays(1)).isLowerThanOrEqualTo(Duration.ofHours(23)));
    }

    @Test
    void hasAtLeastNanos() {
        assertThat(Duration.ofDays(2)).hasAtLeastNanos(1);
        assertThat(Duration.ofNanos(2)).hasAtLeastNanos(2);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ZERO).hasAtLeastNanos(1));
    }

    @Test
    void hasExactlyNanos() {
        assertThat(Duration.ofNanos(10)).hasExactlyNanos(10);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ofNanos(10)).hasExactlyNanos(5));
    }

    @Test
    void doesNotHaveMoreThanNanos() {
        assertThat(Duration.ofNanos(10)).doesNotHaveMoreThanNanos(10);
        assertThat(Duration.ofNanos(10)).doesNotHaveMoreThanNanos(11);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ofNanos(2)).doesNotHaveMoreThanNanos(1));
    }

    @Test
    void hasAtLeastMicros() {
        assertThat(Duration.ofDays(2)).hasAtLeastMicros(1);
        assertThat(Duration.of(2, ChronoUnit.MICROS)).hasAtLeastMicros(2);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ZERO).hasAtLeastMicros(1));
    }

    @Test
    void hasExactlyMicros() {
        assertThat(Duration.of(10, ChronoUnit.MICROS)).hasExactlyMicros(10);
        assertThrows(AssertionError.class, () -> assertThat(Duration.of(10, ChronoUnit.MICROS)).hasExactlyMicros(5));
    }

    @Test
    void doesNotHaveMoreThanMicros() {
        assertThat(Duration.of(10, ChronoUnit.MICROS)).doesNotHaveMoreThanMicros(10);
        assertThat(Duration.of(10, ChronoUnit.MICROS)).doesNotHaveMoreThanMicros(11);
        assertThrows(AssertionError.class, () -> assertThat(Duration.of(2, ChronoUnit.MICROS)).doesNotHaveMoreThanMicros(1));
    }

    @Test
    void hasAtLeastMillis() {
        assertThat(Duration.ofDays(2)).hasAtLeastMillis(1);
        assertThat(Duration.ofMillis(2)).hasAtLeastMillis(2);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ZERO).hasAtLeastMillis(1));
    }

    @Test
    void hasExactlyMillis() {
        assertThat(Duration.ofMillis(10)).hasExactlyMillis(10);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ofMillis(10)).hasExactlyMillis(5));
    }

    @Test
    void doesNotHaveMoreThanMillis() {
        assertThat(Duration.ofMillis(10)).doesNotHaveMoreThanMillis(10);
        assertThat(Duration.ofMillis(10)).doesNotHaveMoreThanMillis(11);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ofMillis(2)).doesNotHaveMoreThanMillis(1));
    }

    @Test
    void hasAtLeastSeconds() {
        assertThat(Duration.ofDays(2)).hasAtLeastSeconds(1);
        assertThat(Duration.ofSeconds(2)).hasAtLeastSeconds(2);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ZERO).hasAtLeastSeconds(1));
    }

    @Test
    void hasExactlySeconds() {
        assertThat(Duration.ofSeconds(10)).hasExactlySeconds(10);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ofSeconds(10)).hasExactlySeconds(5));
    }

    @Test
    void doesNotHaveMoreThanSeconds() {
        assertThat(Duration.ofSeconds(10)).doesNotHaveMoreThanSeconds(10);
        assertThat(Duration.ofSeconds(10)).doesNotHaveMoreThanSeconds(11);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ofSeconds(1)).doesNotHaveMoreThanSeconds(0));
    }

    @Test
    void hasAtLeastMinutes() {
        assertThat(Duration.ofDays(2)).hasAtLeastMinutes(1);
        assertThat(Duration.ofMinutes(2)).hasAtLeastMinutes(2);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ZERO).hasAtLeastMinutes(1));
    }

    @Test
    void hasExactlyMinutes() {
        assertThat(Duration.ofMinutes(10)).hasExactlyMinutes(10);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ofMinutes(10)).hasExactlyMinutes(5));
    }

    @Test
    void doesNotHaveMoreThanMinutes() {
        assertThat(Duration.ofMinutes(10)).doesNotHaveMoreThanMinutes(10);
        assertThat(Duration.ofMinutes(10)).doesNotHaveMoreThanMinutes(11);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ofMinutes(2)).doesNotHaveMoreThanMinutes(1));
    }

    @Test
    void hasAtLeastHours() {
        assertThat(Duration.ofDays(2)).hasAtLeastHours(1);
        assertThat(Duration.ofHours(2)).hasAtLeastHours(2);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ZERO).hasAtLeastHours(1));
    }

    @Test
    void hasExactlyHours() {
        assertThat(Duration.ofHours(10)).hasExactlyHours(10);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ofHours(10)).hasExactlyHours(5));
    }

    @Test
    void doesNotHaveMoreThanHours() {
        assertThat(Duration.ofHours(10)).doesNotHaveMoreThanHours(10);
        assertThat(Duration.ofHours(10)).doesNotHaveMoreThanHours(11);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ofHours(2)).doesNotHaveMoreThanHours(1));
    }

    @Test
    void hasAtLeastDays() {
        assertThat(Duration.ofDays(2)).hasAtLeastDays(1);
        assertThat(Duration.ofDays(2)).hasAtLeastDays(2);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ZERO).hasAtLeastDays(1));
    }

    @Test
    void hasExactlyDays() {
        assertThat(Duration.ofDays(10)).hasExactlyDays(10);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ofDays(10)).hasExactlyDays(5));
    }

    @Test
    void doesNotHaveMoreThanDays() {
        assertThat(Duration.ofDays(10)).doesNotHaveMoreThanDays(10);
        assertThat(Duration.ofDays(10)).doesNotHaveMoreThanDays(11);
        assertThrows(AssertionError.class, () -> assertThat(Duration.ofDays(2)).doesNotHaveMoreThanDays(1));
    }

    @Test
    void isNull() {
        assertThat((Duration) null).isNull();
    }

    @Test
    void isNotNull() {
        assertThat(Duration.ZERO).isNotNull();
    }

    @Test
    void isEqualTo() {
        assertThat(Duration.ZERO).isEqualTo(Duration.ZERO);
    }

    @Test
    void isNotEqualTo() {
        assertThat(Duration.ZERO).isNotEqualTo(Duration.ofSeconds(1));
    }

    @Test
    void isSameAs() {
        assertThat(Duration.ZERO).isSameAs(Duration.ZERO);
    }

    @Test
    void isNotSameAs() {
        assertThat(Duration.ZERO).isNotSameAs(Duration.ofSeconds(1));
    }

    @Test
    void isInstanceOf() {
        assertThat(Duration.ZERO).isInstanceOf(Duration.class);
    }

    @Test
    void isNotInstanceOf() {
        assertThat(Duration.ZERO).isNotInstanceOf(String.class);
    }

    @Test
    void isInstanceOfAny() {
        assertThat(Duration.ZERO).isInstanceOfAny(String.class, Duration.class);
    }

    @Test
    void isNotInstanceOfAny() {
        assertThat(Duration.ZERO).isNotInstanceOfAny(Double.class, String.class);
    }

}