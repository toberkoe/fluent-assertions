package de.toberkoe.fluentassertions.api;

import java.util.Collection;

/**
 * {@code Collection} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Collection)}.
 *
 * @author t.bertram-koehler
 */
public class CollectionAssert<E> extends AbstractCollectionAssert<CollectionAssert<E>, Collection<E>> {

    protected CollectionAssert(Collection<E> value) {
        super(value);
    }

}
