package de.toberkoe.fluentassertions.api;

import java.util.Set;

/**
 * {@code Set} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Set)}.
 *
 * @author t.bertram-koehler
 */
public class SetAssert<E> extends AbstractCollectionAssert<SetAssert<E>, Set<E>> {

    protected SetAssert(Set<E> value) {
        super(value);
    }

}
