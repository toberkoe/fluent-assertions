package de.toberkoe.fluentassertions.api.collections;

import de.toberkoe.fluentassertions.api.Assertions;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * {@code List} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(List)}.
 *
 * @author t.bertram-koehler
 */
public class ListAssert<E> extends AbstractCollectionAssert<ListAssert<E>, List<E>> {

    public ListAssert(List<E> value) {
        super(value);
    }

    public ListAssert isSorted() {
        List<E> list = value.stream().sorted().collect(toList());
        if (Objects.deepEquals(value, list)) {
            return instance;
        }
        throw error("Expected %s to be sorted", value);
    }

    public ListAssert isSortedBy(Comparator<E> comparator) {
        List<E> list = value.stream().sorted(comparator).collect(toList());
        if (Objects.deepEquals(value, list)) {
            return instance;
        }
        throw error("Expected %s to be sorted by %s", value, comparator);
    }

    @SafeVarargs
    public final ListAssert isSortedBy(Function<E, Integer> function, Function<E, Integer>... functions) {
        Comparator<E> comparator = Comparator.comparing(function);
        if (functions != null) {
            for (Function<E, Integer> f : functions) {
                comparator = comparator.thenComparing(f);
            }
        }
        return isSortedBy(comparator);
    }

    public ListAssert isUnsorted() {
        List<E> list = value.stream().sorted().collect(toList());
        if (!Objects.deepEquals(value, list)) {
            return instance;
        }
        throw error("Expected %s to be unsorted", value);
    }
}
