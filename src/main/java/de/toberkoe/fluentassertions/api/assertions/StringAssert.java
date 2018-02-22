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

    public void isNull() {
        if (test(Objects::isNull)) {
            return;
        }
        error("Expected to be null but was %s", value);
    }

    public void isNotNull() {
        if (!test(Objects::isNull)) {
            return;
        }
        error("Expected to be not null");
    }

    public void isEmpty() {
        isNotNull();
        if (test(String::isEmpty)) {
            return;
        }
        error("Expected to be empty but was %s", value);
    }

    public void isNotEmpty() {
        isNotNull();
        if (!test(String::isEmpty)) {
            return;
        }
        error("Expected to be not empty");
    }

    public void isNullOrEmpty() {
        if (test(Objects::isNull, String::isEmpty)) {
            return;
        }
        error("Expected to be null or empty");
    }

    public void isEqualTo(String expected) {
        if (test(expected::equals)) {
            return;
        }

        error("Expected to be %s but was %s", expected, value);
    }

    public void isNotEqualTo(String expected) {
        if (!test(expected::equals)) {
            return;
        }

        error("Expected to be not equal to %s", expected);
    }

    public void isEqualToIgnoringCase(String expected) {
        if (test(expected::equalsIgnoreCase)) {
            return;
        }

        error("Expected to be %s but was %s", expected, value);
    }

    public void contains(String expected) {
        if (test(s -> s.contains(expected))) {
            return;
        }

        error("Expected %s to contain %s", value, expected);
    }

    public void doesNotContain(String expected) {
        if (!test(s -> s.contains(expected))) {
            return;
        }

        error("Expected %s not to contain %s", value, expected);
    }

    public void startsWith(String expected) {
        if (test(s -> s.startsWith(expected))) {
            return;
        }

        error("Expected %s to start with %s", value, expected);
    }

    public void endsWith(String expected) {
        if (test(s -> s.endsWith(expected))) {
            return;
        }

        error("Expected %s to end with %s", value, expected);
    }

    public void matches(String regex) {
        if (test(s -> s.matches(regex))) {
            return;
        }

        error("Expected %s to match regex %s", value, regex);
    }

    public void doesNotMatch(String regex) {
        if (!test(s -> s.matches(regex))) {
            return;
        }

        error("Expected %s not to match regex %s", value, regex);
    }

    public void hasSizeOf(int size) {
        if (test(s -> s.length() == size)) {
            return;
        }

        error("Expected %s to have length of %f", value, size);
    }

    public void hasSameSizeAs(String compareTo) {
        hasSizeOf(compareTo.length());
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

    private void error(String message, Object... objects) {
        if (objects != null) {
            message = format(message, objects);
        }
        throw new AssertionError(message);
    }
}