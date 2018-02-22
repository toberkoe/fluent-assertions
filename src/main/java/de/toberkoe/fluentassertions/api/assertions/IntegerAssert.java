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
public class IntegerAssert {

    private final Integer value;

    protected IntegerAssert(Integer value) {
        this.value = value;
    }

    public IntegerAssert isNegative() {
        if (test(v -> v < 0)) {
            return this;
        }
        throw error("Expected to be negative but was %d", value);
    }

    public IntegerAssert isZero() {
        if (test(v -> v == 0)) {
            return this;
        }
        throw error("Expected to be zero but was %d", value);
    }

    public IntegerAssert isPositive() {
        if (test(v -> v > 0)) {
            return this;
        }
        throw error("Expected to be positive but was %d", value);
    }

    private boolean test(Predicate<Integer> predicate) {
        return testCombined(predicate);
    }

    @SafeVarargs
    private boolean testCombined(Predicate<Integer>... predicates) {
        return Stream.of(predicates).allMatch(p -> p.test(value));
    }

    @SafeVarargs
    private boolean test(Predicate<Integer>... predicates) {
        return Stream.of(predicates).anyMatch(p -> p.test(value));
    }

    private AssertionError error(String message, Object... objects) {
        if (objects != null) {
            message = format(message, objects);
        }
        return new AssertionError(message);
    }
}