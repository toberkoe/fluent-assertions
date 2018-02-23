package de.toberkoe.fluentassertions.api;

import java.util.*;
import java.util.stream.Stream;

/**
 * {@code Collection} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Collection)}.
 *
 * @author t.bertram-koehler
 */
public class CollectionAssert extends AbstractObjectAssert<CollectionAssert, Collection> {

    protected CollectionAssert(Collection value) {
        super(value);
    }

    public CollectionAssert isEmpty() {
        if (test(Collection::isEmpty)) {
            return instance;
        }
        throw error("Expected to be empty but was %s", value);
    }

    public CollectionAssert isNotEmpty() {
        if (!test(Collection::isEmpty)) {
            return instance;
        }
        throw error("Expected to be not empty");
    }

    public CollectionAssert isNullOrEmpty() {
        if (test(Objects::isNull, v -> v != null && v.isEmpty())) {
            return instance;
        }
        throw error("Expected to be null or empty but was %s", value);
    }

    public CollectionAssert hasSizeOf(int expectedSize) {
        if (test(v -> v.size() == expectedSize)) {
            return instance;
        }
        throw error("Expected to have size of %s instead of actual size of %s", expectedSize, value.size());
    }

    public CollectionAssert hasSameSizeAs(Collection collection) {
        return hasSizeOf(collection.size());
    }

    public CollectionAssert contains(Object object) {
        if (test(v -> v.stream().anyMatch(o -> Objects.equals(o, object)))) {
            return instance;
        }

        if (object == null) {
            throw error("Expected containing null");
        } else {
            throw error("Expected containing %s", object);
        }
    }

    public CollectionAssert doesNotContain(Object object) {
        if (test(v -> v.stream().noneMatch(o -> Objects.equals(o, object)))) {
            return instance;
        }
        if (object == null) {
            throw error("Expected not containing null");
        } else {
            throw error("Expected not containing %s", object);
        }
    }

    public CollectionAssert containsNull() {
        return contains(null);
    }

    public CollectionAssert doesNotContainNull() {
        return doesNotContain(null);
    }

    public CollectionAssert containsOnly(Object... objects) {
        Stream.of(objects).forEach(this::contains);
        return hasSizeOf(objects.length);
    }

    public CollectionAssert containsAllOf(Object... objects) {
        Stream.of(objects).forEach(this::contains);
        return instance;
    }

    public CollectionAssert containsNoneOf(Object... objects) {
        Stream.of(objects).forEach(this::doesNotContain);
        return instance;
    }

    public CollectionAssert containsSequence(Object... objects) {
        containsAllOf(objects);
        List list = new ArrayList<>(value);
        int start = list.indexOf(objects[0]);
        int end = list.indexOf(objects[objects.length - 1]) + 1;

        List sequence = list.subList(start, end > list.size() ? list.size() : end);
        if (Objects.deepEquals(sequence, Arrays.asList(objects))) {
            return instance;
        }
        throw error("Expected to contain sequence %s", Arrays.asList(objects));
    }

    public CollectionAssert startsWith(Object... objects) {
        if (objects.length == value.size()) {
            return containsOnly(objects);
        }
        containsAllOf(objects);

        List list = new ArrayList<>(value);
        int end = list.indexOf(objects[objects.length - 1]) + 1;
        Collection subList = list.subList(0, end > list.size() ? list.size() : end);
        if (Objects.deepEquals(subList, Arrays.asList(objects))) {
            return instance;
        }
        throw error("Expected to start with %s but started with %s", Arrays.asList(objects), subList);
    }

    public CollectionAssert endsWith(Object... objects) {
        if (objects.length == value.size()) {
            return containsOnly(objects);
        }
        containsAllOf(objects);

        List list = new ArrayList<>(value);
        int start = list.lastIndexOf(objects[0]);
        Collection subList = list.subList(start, list.size());
        if (Objects.deepEquals(subList, Arrays.asList(objects))) {
            return instance;
        }
        throw error("Expected to end with %s but ended with %s", Arrays.asList(objects), subList);
    }

    public CollectionAssert doesNotHaveDuplicates() {
        Set set = new HashSet<>(value);
        return hasSameSizeAs(set);
    }

}
