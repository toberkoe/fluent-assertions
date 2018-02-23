package de.toberkoe.fluentassertions.api;

import java.util.*;
import java.util.stream.Stream;

/**
 * Abstract {@code Collection} Assertions.
 *
 * @author t.bertram-koehler
 */
public class AbstractCollectionAssert<S extends AbstractCollectionAssert<S, C>, C extends Collection> extends AbstractObjectAssert<S, C> {

    private enum Position {
        UNKNOWN, START, END
    }

    protected AbstractCollectionAssert(C value) {
        super(value);
    }

    public S isEmpty() {
        if (test(Collection::isEmpty)) {
            return instance;
        }
        throw error("Expected to be empty but was %s", value);
    }

    public S isNotEmpty() {
        if (!test(Collection::isEmpty)) {
            return instance;
        }
        throw error("Expected to be not empty");
    }

    public S isNullOrEmpty() {
        if (test(Objects::isNull, v -> v != null && v.isEmpty())) {
            return instance;
        }
        throw error("Expected to be null or empty but was %s", value);
    }

    public S hasSizeOf(int expectedSize) {
        if (test(v -> v.size() == expectedSize)) {
            return instance;
        }
        throw error("Expected to have size of %s instead of actual size of %s", expectedSize, value.size());
    }

    public S hasSameSizeAs(Collection collection) {
        return hasSizeOf(collection.size());
    }

    public S contains(Object object) {
        if (test(v -> v.stream().anyMatch(o -> Objects.equals(o, object)))) {
            return instance;
        }

        if (object == null) {
            throw error("Expected containing null");
        } else {
            throw error("Expected containing %s", object);
        }
    }

    public S doesNotContain(Object object) {
        if (test(v -> v.stream().noneMatch(o -> Objects.equals(o, object)))) {
            return instance;
        }
        if (object == null) {
            throw error("Expected not containing null");
        } else {
            throw error("Expected not containing %s", object);
        }
    }

    public S containsNull() {
        return contains(null);
    }

    public S doesNotContainNull() {
        return doesNotContain(null);
    }

    public S containsOnly(Object... objects) {
        Stream.of(objects).forEach(this::contains);
        return hasSizeOf(objects.length);
    }

    public S containsAllOf(Object... objects) {
        Stream.of(objects).forEach(this::contains);
        return instance;
    }

    public S containsNoneOf(Object... objects) {
        Stream.of(objects).forEach(this::doesNotContain);
        return instance;
    }

    public S containsSequence(Object... objects) {
        containsAllOf(objects);
        return isSublistAsExpected(Position.UNKNOWN, objects);
    }

    private S isSublistAsExpected(Position position, Object[] objects) {
        List list = new ArrayList<>(value);
        if (value instanceof Set) {
            Collections.sort(list);
        }

        int start = 0;
        int end = 0;
        switch (position) {
            case START:
                start = 0;
                end = list.indexOf(objects[objects.length - 1]) + 1;
                break;
            case UNKNOWN:
                start = list.indexOf(objects[0]);
                end = list.indexOf(objects[objects.length - 1]) + 1;
                break;
            case END:
                start = list.lastIndexOf(objects[0]);
                end = list.size();
                break;
        }

        List sequence = list.subList(start, end > list.size() ? list.size() : end);
        if (Objects.deepEquals(sequence, Arrays.asList(objects))) {
            return instance;
        }

        throw error("Expected to contain sequence %s", sequence);
    }

    public S startsWith(Object... objects) {
        if (objects.length == value.size()) {
            return containsOnly(objects);
        }
        containsAllOf(objects);
        return isSublistAsExpected(Position.START, objects);
    }

    public S endsWith(Object... objects) {
        if (objects.length == value.size()) {
            return containsOnly(objects);
        }
        containsAllOf(objects);
        return isSublistAsExpected(Position.END, objects);
    }

    public S doesNotHaveDuplicates() {
        Set set = new HashSet<>(value);
        return hasSameSizeAs(set);
    }

}
