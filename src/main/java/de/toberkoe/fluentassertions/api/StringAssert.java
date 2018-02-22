package de.toberkoe.fluentassertions.api;

import java.util.Objects;

/**
 * {@code String} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(String)}.
 *
 * @author t.bertram-koehler
 */
public class StringAssert extends AbstractObjectAssert<StringAssert, String> {

    protected StringAssert(String value) {
        super(value);
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

        throw error("Expected %s to have length of %s", value, size);
    }

    public StringAssert hasSameSizeAs(String compareTo) {
        return hasSizeOf(compareTo.length());
    }

}