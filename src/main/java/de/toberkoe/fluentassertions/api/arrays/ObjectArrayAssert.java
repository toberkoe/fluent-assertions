package de.toberkoe.fluentassertions.api.arrays;

import de.toberkoe.fluentassertions.api.Assertions;

/**
 * {@code Object[]} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Object[])}.
 *
 * @author t.bertram-koehler
 */
public class ObjectArrayAssert extends AbstractArrayAssert<ObjectArrayAssert, Object> {

    public ObjectArrayAssert(Object[] value) {
        super(value);
    }
}
