package de.toberkoe.fluentassertions.api.date;

import de.toberkoe.fluentassertions.api.objects.AbstractObjectAssert;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DurationAssert extends AbstractObjectAssert<DurationAssert, Duration> {

    public DurationAssert(Duration value) {
        super(value);
    }

    public DurationAssert isPositive() {
        if (!value.isNegative() && !value.isZero()) {
            return instance;
        }
        throw error("Expected to be positive but was %s", value);
    }

    public DurationAssert isZero() {
        if (value.isZero()) {
            return instance;
        }
        throw error("Expected to be zero but was %s", value);
    }

    public DurationAssert isNegative() {
        if (value.isNegative()) {
            return instance;
        }
        throw error("Expected to be negative but was %s", value);
    }

    public DurationAssert isGreaterThanOrEqualTo(Duration otherDuration) {
        if (value.compareTo(otherDuration) >= 0) {
            return instance;
        }
        throw error("Expected to be greater than or equal to %s but was %s", otherDuration, value);
    }

    public DurationAssert isGreaterThan(Duration otherDuration) {
        if (value.compareTo(otherDuration) > 0) {
            return instance;
        }
        throw error("Expected to be greater than %s but was %s", otherDuration, value);
    }

    public DurationAssert isLowerThan(Duration otherDuration) {
        if (value.compareTo(otherDuration) < 0) {
            return instance;
        }
        throw error("Expected to be lower than %s but was %s", otherDuration, value);
    }

    public DurationAssert isLowerThanOrEqualTo(Duration otherDuration) {
        if (value.compareTo(otherDuration) <= 0) {
            return instance;
        }
        throw error("Expected to be lower than or equal to %s but was %s", otherDuration, value);
    }

    public DurationAssert hasAtLeastNanos(int nanos) {
        return hasAtLeast(nanos, ChronoUnit.NANOS);
    }

    public DurationAssert hasExactlyNanos(int nanos) {
        return hasExactly(nanos, ChronoUnit.NANOS);
    }

    public DurationAssert doesNotHaveMoreThanNanos(int nanos) {
        return doesNotHaveMoreThan(nanos, ChronoUnit.NANOS);
    }

    public DurationAssert hasAtLeastMicros(int micros) {
        return hasAtLeast(micros, ChronoUnit.MICROS);
    }

    public DurationAssert hasExactlyMicros(int micros) {
        return hasExactly(micros, ChronoUnit.MICROS);
    }

    public DurationAssert doesNotHaveMoreThanMicros(int micros) {
        return doesNotHaveMoreThan(micros, ChronoUnit.MICROS);
    }

    public DurationAssert hasAtLeastMillis(int millis) {
        return hasAtLeast(millis, ChronoUnit.MILLIS);
    }

    public DurationAssert hasExactlyMillis(int millis) {
        return hasExactly(millis, ChronoUnit.MILLIS);
    }

    public DurationAssert doesNotHaveMoreThanMillis(int millis) {
        return doesNotHaveMoreThan(millis, ChronoUnit.MILLIS);
    }

    public DurationAssert hasAtLeastSeconds(int seconds) {
        return hasAtLeast(seconds, ChronoUnit.SECONDS);
    }

    public DurationAssert hasExactlySeconds(int seconds) {
        return hasExactly(seconds, ChronoUnit.SECONDS);
    }

    public DurationAssert doesNotHaveMoreThanSeconds(int seconds) {
        return doesNotHaveMoreThan(seconds, ChronoUnit.SECONDS);
    }

    public DurationAssert hasAtLeastMinutes(int minutes) {
        return hasAtLeast(minutes, ChronoUnit.MINUTES);
    }

    public DurationAssert hasExactlyMinutes(int minutes) {
        return hasExactly(minutes, ChronoUnit.MINUTES);
    }

    public DurationAssert doesNotHaveMoreThanMinutes(int minutes) {
        return doesNotHaveMoreThan(minutes, ChronoUnit.MINUTES);
    }

    public DurationAssert hasAtLeastHours(int hours) {
        return hasAtLeast(hours, ChronoUnit.HOURS);
    }

    public DurationAssert hasExactlyHours(int hours) {
        return hasExactly(hours, ChronoUnit.HOURS);
    }

    public DurationAssert doesNotHaveMoreThanHours(int hours) {
        return doesNotHaveMoreThan(hours, ChronoUnit.HOURS);
    }

    public DurationAssert hasAtLeastDays(int days) {
        return hasAtLeast(days, ChronoUnit.DAYS);
    }

    public DurationAssert hasExactlyDays(int days) {
        return hasExactly(days, ChronoUnit.DAYS);
    }

    public DurationAssert doesNotHaveMoreThanDays(int days) {
        return doesNotHaveMoreThan(days, ChronoUnit.DAYS);
    }

    private DurationAssert hasAtLeast(int count, ChronoUnit unit) {
        if (value.toNanos() >= Duration.of(count, unit).toNanos()) {
            return instance;
        }
        throw error("Expected to have at least %s nanoseconds but was %s nanoseconds", Duration.of(count, unit).toNanos(), value.toNanos());
    }

    private DurationAssert hasExactly(int count, ChronoUnit unit) {
        if (value.toNanos() == Duration.of(count, unit).toNanos()) {
            return instance;
        }
        throw error("Expected to have exactly %s nanoseconds but was %s nanoseconds", Duration.of(count, unit).toNanos(), value.toNanos());
    }

    private DurationAssert doesNotHaveMoreThan(int count, ChronoUnit unit) {
        if (value.toNanos() <= Duration.of(count, unit).toNanos()) {
            return instance;
        }
        throw error("Expected to have not more than %s nanoseconds but was %s nanoseconds", Duration.of(count, unit).toNanos(), value.toNanos());
    }
}
