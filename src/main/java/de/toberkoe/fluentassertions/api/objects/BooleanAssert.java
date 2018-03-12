package de.toberkoe.fluentassertions.api.objects;

import de.toberkoe.fluentassertions.api.Assertions;

/**
 * {@code Boolean} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Boolean)}.
 *
 * @author t.bertram-koehler
 */
public class BooleanAssert extends AbstractObjectAssert<BooleanAssert, Boolean> {

    public BooleanAssert(Boolean value) {
        super(value);
    }

    public BooleanAssert isTrue() {
        if (test(v -> v)) {
            return instance;
        }
        throw error("Expected %s to be true", value);
    }

    public BooleanAssert isFalse() {
        if (test(v -> !v)) {
            return instance;
        }
        throw error("Expected %s to be false", value);
    }
}
