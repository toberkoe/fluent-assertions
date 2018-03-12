package de.toberkoe.fluentassertions.api.numbers;

import de.toberkoe.fluentassertions.api.Assertions;

/**
 * {@code Short} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Short)}.
 *
 * @author t.bertram-koehler
 */
public class ShortAssert extends NumberAssert<ShortAssert, Short> {

    public ShortAssert(Short value) {
        super(value);
    }
}