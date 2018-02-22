package de.toberkoe.fluentassertions.api.assertions;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 * {@code String} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(String)}.
 *
 * @author t.bertram-koehler
 */
public class StringAssert {

    private final String value;

    protected StringAssert(String value) {
        this.value = value;
    }

    public StringAssert isNull() {
        if (test(Objects::isNull)) {
            return this;
        }
        throw error("Expected to be null but was %s", value);
    }

    public StringAssert isNotNull() {
        if (!test(Objects::isNull)) {
            return this;
        }
        throw error("Expected to be not null");
    }

    public StringAssert isEmpty() {
        isNotNull();
        if (test(String::isEmpty)) {
            return this;
        }
        throw error("Expected to be empty but was %s", value);
    }

    public StringAssert isNotEmpty() {
        isNotNull();
        if (!test(String::isEmpty)) {
            return this;
        }
        throw error("Expected to be not empty");
    }

    public StringAssert isNullOrEmpty() {
        if (test(Objects::isNull, String::isEmpty)) {
            return this;
        }
        throw error("Expected to be null or empty");
    }

    public StringAssert isEqualTo(String expected) {
        if (test(expected::equals)) {
            return this;
        }

        throw error("Expected to be %s but was %s", expected, value);
    }

    public StringAssert isNotEqualTo(String expected) {
        if (!test(expected::equals)) {
            return this;
        }

        throw error("Expected to be not equal to %s", expected);
    }

    public StringAssert isEqualToIgnoringCase(String expected) {
        if (test(expected::equalsIgnoreCase)) {
            return this;
        }

        throw error("Expected to be %s but was %s", expected, value);
    }

    public StringAssert contains(String expected) {
        if (test(s -> s.contains(expected))) {
            return this;
        }

        throw error("Expected %s to contain %s", value, expected);
    }

    public StringAssert doesNotContain(String expected) {
        if (!test(s -> s.contains(expected))) {
            return this;
        }

        throw error("Expected %s not to contain %s", value, expected);
    }

    public StringAssert startsWith(String expected) {
        if (test(s -> s.startsWith(expected))) {
            return this;
        }

        throw error("Expected %s to start with %s", value, expected);
    }

    public StringAssert endsWith(String expected) {
        if (test(s -> s.endsWith(expected))) {
            return this;
        }

        throw error("Expected %s to end with %s", value, expected);
    }

    public StringAssert matches(String regex) {
        if (test(s -> s.matches(regex))) {
            return this;
        }

        throw error("Expected %s to match regex %s", value, regex);
    }

    public StringAssert doesNotMatch(String regex) {
        if (!test(s -> s.matches(regex))) {
            return this;
        }

        throw error("Expected %s not to match regex %s", value, regex);
    }

    public StringAssert hasSizeOf(int size) {
        if (test(s -> s.length() == size)) {
            return this;
        }

        throw error("Expected %s to have length of %d", value, size);
    }

    public StringAssert hasSameSizeAs(String compareTo) {
        return hasSizeOf(compareTo.length());
    }

    private boolean test(Predicate<String> predicate) {
        return testCombined(predicate);
    }

    @SafeVarargs
    private boolean testCombined(Predicate<String>... predicates) {
        return Stream.of(predicates).allMatch(p -> p.test(value));
    }

    @SafeVarargs
    private boolean test(Predicate<String>... predicates) {
        return Stream.of(predicates).anyMatch(p -> p.test(value));
    }

    private AssertionError error(String message, Object... objects) {
        if (objects != null) {
            message = format(message, objects);
        }
        return new AssertionError(message);
    }
}