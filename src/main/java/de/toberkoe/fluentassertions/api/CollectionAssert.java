package de.toberkoe.fluentassertions.api;

import java.util.Collection;

/**
 * {@code Collection} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Collection)}.
 *
 * @author t.bertram-koehler
 */
public class CollectionAssert extends AbstractCollectionAssert<CollectionAssert, Collection> {

    protected CollectionAssert(Collection value) {
        super(value);
    }

}
