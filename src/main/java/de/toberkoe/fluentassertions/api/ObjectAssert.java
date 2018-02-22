package de.toberkoe.fluentassertions.api;

/**
 * {@code Object} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Object)}.
 *
 * @author t.bertram-koehler
 */
public class ObjectAssert extends AbstractObjectAssert<ObjectAssert, Object> {

    protected ObjectAssert(Object value) {
        super(value);
    }

}