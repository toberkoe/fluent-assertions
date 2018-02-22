package de.toberkoe.fluentassertions.api;

/**
 * {@code Integer} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Integer)}.
 *
 * @author t.bertram-koehler
 */
public class NumberAssert<S extends NumberAssert<S, T>, T extends Number> extends AbstractObjectAssert<S, T> {

    protected NumberAssert(T value) {
        super(value);
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


}