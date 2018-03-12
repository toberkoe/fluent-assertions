package de.toberkoe.fluentassertions.api.collections;

import de.toberkoe.fluentassertions.api.Assertions;

import java.util.Set;

/**
 * {@code Set} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Set)}.
 *
 * @author t.bertram-koehler
 */
public class SetAssert<E> extends AbstractCollectionAssert<SetAssert<E>, Set<E>> {

    public SetAssert(Set<E> value) {
        super(value);
    }

}
