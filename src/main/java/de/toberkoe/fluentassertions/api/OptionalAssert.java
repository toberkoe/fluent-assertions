package de.toberkoe.fluentassertions.api;

import java.util.Optional;

/**
 * {@code Integer} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Integer)}.
 *
 * @author t.bertram-koehler
 */
public class OptionalAssert<E> extends AbstractObjectAssert<OptionalAssert<E>, Optional<E>> {

    protected OptionalAssert(Optional<E> value) {
        super(value);
    }

    public OptionalAssert<E> isEmpty() {
        if (test(o -> !o.isPresent())) {
            return instance;
        }
        throw error("Expected %s to be empty", value);
    }

    public OptionalAssert<E> isNotEmpty() {
        if (test(Optional::isPresent)) {
            return instance;
        }
        throw error("Expected %s to be not empty", value);
    }


    public OptionalAssert<E> isValueEqualTo(Object expected) {
        isNotEmpty();
        if (test(v -> v.get().equals(expected))) {
            return instance;
        }
        throw error("Expected %s to be equal to %s", value, expected);
    }

    public OptionalAssert<E> isValueNotEqualTo(Object expected) {
        isNotEmpty();
        if (test(v -> !v.get().equals(expected))) {
            return instance;
        }
        throw error("Expected %s not to be equal to %s", value, expected);
    }
}
