package de.toberkoe.fluentassertions.api;

import java.util.*;
import java.util.stream.Stream;

/**
 * Abstract Assertions for {@code Arrays}
 *
 * @author t.bertram-koehler
 */
public abstract class AbstractArrayAssert<S extends AbstractArrayAssert<S, T>, T> extends AbstractObjectAssert<S, T[]> {

    //TODO tests for:
    //assertion classes for primitives: boolean[], int[], long[], double[], byte[]

    //TODO implement these methods:
    //isSorted
    //isUnsorted
    //isSortedBy

    private enum Position {
        UNKNOWN, START, END
    }

    protected AbstractArrayAssert(T[] value) {
        super(value);
    }

    public S isEmpty() {
        if (isArrayEmpty()) {
            return instance;
        }
        throw error("Expected to be empty but was %s", Arrays.toString(value));
    }

    public S isNotEmpty() {
        if (isArrayEmpty()) {
            throw error("Expected to be not empty");
        }
        return instance;
    }

    public S isNullOrEmpty() {
        if (value == null || isArrayEmpty()) {
            return instance;
        }
        throw error("Expected to be null or empty but was %s", Arrays.toString(value));
    }

    public S hasSizeOf(int expectedSize) {
        if (value.length == expectedSize) {
            return instance;
        }
        throw error("Expected to have size of %s but was %s", expectedSize, value.length);
    }

    public S hasSameSizeAs(T[] expectedSize) {
        new ObjectArrayAssert(expectedSize).isNotNull();
        return hasSizeOf(expectedSize.length);
    }

    public S contains(T expectedValue) {
        if (Stream.of(value).anyMatch(v -> Objects.equals(v, expectedValue))) {
            return instance;
        }
        throw error("Expected to contain '%s'", expectedValue);
    }

    public S doesNotContain(T expectedValue) {
        if (Stream.of(value).noneMatch(v -> Objects.equals(v, expectedValue))) {
            return instance;
        }
        throw error("Expected to not contain '%s'", expectedValue);
    }

    public S containsNull() {
        if (Stream.of(value).anyMatch(Objects::isNull)) {
            return instance;
        }
        throw error("Expected to contain null value");
    }

    public S doesNotContainNull() {
        if (Stream.of(value).noneMatch(Objects::isNull)) {
            return instance;
        }
        throw error("Expected not to contain null value");
    }

    @SafeVarargs
    public final S containsOnly(T... objects) {
        Stream.of(objects).forEach(this::contains);
        return hasSizeOf(objects.length);
    }

    @SafeVarargs
    public final S containsAllOf(T... objects) {
        Stream.of(objects).forEach(this::contains);
        return instance;
    }

    @SafeVarargs
    public final S containsNoneOf(T... objects) {
        Stream.of(objects).forEach(this::doesNotContain);
        return instance;
    }

    @SafeVarargs
    public final S containsSequence(T... objects) {
        containsAllOf(objects);
        return isSublistAsExpected(Position.UNKNOWN, objects);
    }

    @SafeVarargs
    public final S startsWith(T... objects) {
        if (objects.length == value.length) {
            return containsOnly(objects);
        }
        containsAllOf(objects);
        return isSublistAsExpected(Position.START, objects);
    }

    @SafeVarargs
    public final S endsWith(T... objects) {
        if (objects.length == value.length) {
            return containsOnly(objects);
        }
        containsAllOf(objects);
        return isSublistAsExpected(Position.END, objects);
    }

    public S doesNotHaveDuplicates() {
        //FIXME throw exception if not implementing comparable?
        List<T> list = List.of(value);
        Set<T> set = new HashSet<>(list);
        return hasSizeOf(set.size());
    }

    private S isSublistAsExpected(Position position, T[] objects) {
        List<T> list = Arrays.asList(value);

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

    private boolean isArrayEmpty() {
        return value.length == 0 || Stream.of(value).noneMatch(Objects::nonNull);
    }
}
