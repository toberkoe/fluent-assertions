package de.toberkoe.fluentassertions.api;

/**
 * {@code Short} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Short)}.
 *
 * @author t.bertram-koehler
 */
public class ShortAssert extends NumberAssert<ShortAssert, Short> {

    protected ShortAssert(Short value) {
        super(value);
    }
}