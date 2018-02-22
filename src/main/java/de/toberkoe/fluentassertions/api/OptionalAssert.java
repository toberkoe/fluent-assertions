package de.toberkoe.fluentassertions.api;

import java.util.Optional;

/**
 * {@code Integer} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Integer)}.
 *
 * @author t.bertram-koehler
 */
public class OptionalAssert extends AbstractObjectAssert<OptionalAssert, Optional> {

    protected OptionalAssert(Optional value) {
        super(value);
    }

    public OptionalAssert isEmpty() {
        if (test(o -> !o.isPresent())) {
            return instance;
        }
        throw error("Expected %s to be empty", value);
    }

    public OptionalAssert isNotEmpty() {
        if (test(Optional::isPresent)) {
            return instance;
        }
        throw error("Expected %s to be not empty", value);
    }


    public OptionalAssert isValueEqualTo(Object expected) {
        isNotEmpty();
        if (test(v -> v.get().equals(expected))) {
            return instance;
        }
        throw error("Expected %s to be equal to %s", value, expected);
    }

    public OptionalAssert isValueNotEqualTo(Object expected) {
        isNotEmpty();
        if (test(v -> !v.get().equals(expected))) {
            return instance;
        }
        throw error("Expected %s not to be equal to %s", value, expected);
    }
}
