package de.toberkoe.fluentassertions.api.arrays;

import de.toberkoe.fluentassertions.api.objects.AbstractObjectAssert;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Abstract Assertions for {@code Arrays}
 *
 * @author t.bertram-koehler
 */
public abstract class AbstractArrayAssert<S extends AbstractArrayAssert<S, T>, T> extends AbstractObjectAssert<S, T[]> {

    //TODO tests for:
    //isSortedBy extensions for String[], Boolean[], Integer[], Double[], Long[]

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

        T first = objects[0];
        T last = objects[objects.length - 1];
        for (int i = 0; i < value.length; i++) {
            T actual = value[i];
            if (!Objects.equals(actual, first)) {
                continue;
            }

            int endOfSequence = i + objects.length - 1;
            if (endOfSequence >= value.length) {
                throw error("Expected to contain sequence %s", Arrays.toString(objects));
            }

            T possibleEnd = value[endOfSequence];
            if (!Objects.equals(possibleEnd, last)) {
                continue;
            }

            T[] possibleSequence = Arrays.copyOfRange(value, i, endOfSequence + 1);
            if (Arrays.deepEquals(possibleSequence, objects)) {
                return instance;
            }
        }
        throw error("Expected to contain sequence %s", Arrays.toString(objects));
    }

    @SafeVarargs
    public final S startsWith(T... objects) {
        if (objects.length == value.length) {
            return containsOnly(objects);
        }
        containsAllOf(objects);

        for (int i = 0; i < objects.length; i++) {
            if (!Objects.equals(value[i], objects[i])) {
                throw error("Expected to start with %s", Arrays.toString(objects));
            }
        }
        return instance;
    }

    @SafeVarargs
    public final S endsWith(T... objects) {
        if (objects.length == value.length) {
            return containsOnly(objects);
        }
        containsAllOf(objects);
        for (int i = 0; i < objects.length; i++) {
            T actual = value[value.length - 1 - i];
            T expected = objects[objects.length - 1 - i];
            if (!Objects.equals(actual, expected)) {
                throw error("Expected to end with %s", Arrays.toString(objects));
            }
        }
        return instance;
    }

    public S doesNotHaveDuplicates() {
        List<T> list = List.of(value);
        Set<T> set = new HashSet<>(list);
        return hasSizeOf(set.size());
    }

    public S isSorted() {
        List<T> list = Stream.of(value).sorted().collect(toList());
        if (Objects.deepEquals(Arrays.asList(value), list)) {
            return instance;
        }
        throw error("Expected %s to be sorted", Arrays.toString(value));
    }

    public S isSortedBy(Comparator<T> comparator) {
        List<T> list = Stream.of(value).sorted(comparator).collect(toList());
        if (Objects.deepEquals(Arrays.asList(value), list)) {
            return instance;
        }
        throw error("Expected %s to be sorted by %s", Arrays.toString(value), comparator);
    }

    @SafeVarargs
    public final S isSortedBy(Function<T, Integer> function, Function<T, Integer>... functions) {
        Comparator<T> comparator = Comparator.comparing(function);
        if (functions != null) {
            for (Function<T, Integer> f : functions) {
                comparator = comparator.thenComparing(f);
            }
        }
        return isSortedBy(comparator);
    }

    public S isUnsorted() {
        List<T> list = Stream.of(value).sorted().collect(toList());
        if (!Objects.deepEquals(Arrays.asList(value), list)) {
            return instance;
        }
        throw error("Expected %s to be unsorted", Arrays.toString(value));
    }

    private boolean isArrayEmpty() {
        return value.length == 0 || Stream.of(value).noneMatch(Objects::nonNull);
    }
}
