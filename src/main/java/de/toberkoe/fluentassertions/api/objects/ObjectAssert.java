package de.toberkoe.fluentassertions.api.objects;

import de.toberkoe.fluentassertions.api.Assertions;

/**
 * {@code Object} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Object)}.
 *
 * @author t.bertram-koehler
 */
public class ObjectAssert extends AbstractObjectAssert<ObjectAssert, Object> {

    public ObjectAssert(Object value) {
        super(value);
    }

}