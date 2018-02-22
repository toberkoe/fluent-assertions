package de.toberkoe.fluentassertions.api.assertions;

import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 * {@code Integer} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Integer)}.
 *
 * @author t.bertram-koehler
 */
public class NumberAssert<S extends NumberAssert<S, T>, T extends Number> {

    private final T value;
    private final S instance;

    protected NumberAssert(T value) {
        this.value = value;
        instance = (S) this;
    }

    public S isNegative() {
        if (test(v -> v.doubleValue() < 0)) {
            return instance;
        }
        throw error("Expected to be negative but was %s", value);
    }

    public S isZero() {
        if (test(v -> v.doubleValue() == 0)) {
            return instance;
        }
        throw error("Expected to be zero but was %s", value);
    }

    public S isPositive() {
        if (test(v -> v.doubleValue() > 0)) {
            return instance;
        }
        throw error("Expected to be positive but was %s", value);
    }

    public S isLessThan(T givenValue) {
        if (test(v -> v.doubleValue() < givenValue.doubleValue())) {
            return instance;
        }
        throw error("Expected %s to be less than %s", value, givenValue);
    }

    public S isGreaterThan(T givenValue) {
        if (test(v -> v.doubleValue() > givenValue.doubleValue())) {
            return instance;
        }
        throw error("Expected %s to be greater than %s", value, givenValue);
    }

    public S isEqualTo(T givenValue) {
        if (test(v -> v.equals(givenValue))) {
            return instance;
        }
        throw error("Expected %s to be equal to %s", value, givenValue);
    }

    public S isNotEqualTo(T givenValue) {
        if (!test(v -> v.equals(givenValue))) {
            return instance;
        }
        throw error("Expected %s to be not equal to %s", value, givenValue);
    }

    public S isLessThanOrEqualTo(T givenValue) {
        if (test(v -> v.doubleValue() < givenValue.doubleValue(), v -> v.equals(givenValue))) {
            return instance;
        }
        throw error("Expected %s to be less than or equal to %s", value, givenValue);
    }

    public S isGreaterThanOrEqualTo(T givenValue) {
        if (test(v -> v.doubleValue() > givenValue.doubleValue(), v -> v.equals(givenValue))) {
            return instance;
        }
        throw error("Expected %s to be greater than or equal to %s", value, givenValue);
    }

    private boolean test(Predicate<T> predicate) {
        return testCombined(predicate);
    }

    @SafeVarargs
    private boolean testCombined(Predicate<T>... predicates) {
        return Stream.of(predicates).allMatch(p -> p.test(value));
    }

    @SafeVarargs
    private boolean test(Predicate<T>... predicates) {
        return Stream.of(predicates).anyMatch(p -> p.test(value));
    }

    @SafeVarargs
    private AssertionError error(String message, T... objects) {
        if (objects != null) {
            message = format(message, Stream.of(objects)
                    .map(this::formatNumber).toArray(String[]::new));
        }
        return new AssertionError(message);
    }

    protected String formatNumber(T object) {
        return object.toString();
    }
}