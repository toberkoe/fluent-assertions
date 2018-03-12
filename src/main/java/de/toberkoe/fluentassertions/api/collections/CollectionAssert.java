package de.toberkoe.fluentassertions.api.collections;

import de.toberkoe.fluentassertions.api.Assertions;

import java.util.Collection;

/**
 * {@code Collection} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Collection)}.
 *
 * @author t.bertram-koehler
 */
public class CollectionAssert<E> extends AbstractCollectionAssert<CollectionAssert<E>, Collection<E>> {

    public CollectionAssert(Collection<E> value) {
        super(value);
    }

}
