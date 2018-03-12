package de.toberkoe.fluentassertions.api;

import org.junit.jupiter.api.Test;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;
import static java.util.Comparator.comparingLong;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LongArrayAssertTest {

    @Test
    void isEmpty() {
        assertThat(new long[]{}).isEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1}).isEmpty());
    }

    @Test
    void isNotEmpty() {
        assertThat(new long[]{1}).isNotEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new long[]{}).isNotEmpty());
    }

    @Test
    void isNullOrEmpty() {
        assertThat(new long[]{}).isNullOrEmpty();
        assertThat((Object[]) null).isNullOrEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1}).isNullOrEmpty());
    }

    @Test
    void hasSizeOf() {
        assertThat(new long[]{1}).hasSizeOf(1);
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1}).hasSizeOf(0));
    }

    @Test
    void hasSameSizeAs() {
        assertThat(new long[]{1}).hasSameSizeAs(new long[]{1});
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1}).hasSameSizeAs(new long[]{}));
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1}).hasSameSizeAs(new long[]{1, 2}));
    }

    @Test
    void contains() {
        assertThat(new long[]{1}).contains(1L);
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1}).contains(2L));
    }

    @Test
    void doesNotContain() {
        assertThat(new long[]{1}).doesNotContain(2L);
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1}).doesNotContain(1L));
    }

    @Test
    void containsNull() {
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1}).containsNull());
    }

    @Test
    void doesNotContainNull() {
        assertThat(new long[]{1}).doesNotContainNull();
    }

    @Test
    void containsOnly() {
        assertThat(new long[]{1L, 2L, 3L}).containsOnly(1L, 2L, 3L);
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1L, 2L, 3L, 4, 5}).containsOnly(1L, 2L, 3L));
    }

    @Test
    void containsAllOf() {
        assertThat(new long[]{1L, 2L, 3L, 4, 5}).containsAllOf(1L, 2L);
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1L, 2L, 3L}).containsAllOf(1L, 5L));
    }

    @Test
    void containsNoneOf() {
        assertThat(new long[]{1L, 2L, 3L}).containsNoneOf(4L, 5L);
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1L, 2L, 3L}).containsNoneOf(1L, 2L));
    }

    @Test
    void containsSequence() {
        assertThat(new long[]{1L, 2L, 3L, 4, 5}).containsSequence(2L, 3L, 4L);
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1L, 2L, 3L, 4}).containsSequence(3L, 2L));
    }

    @Test
    void startsWith() {
        assertThat(new long[]{1L, 2L, 3L, 4, 5}).startsWith(1L, 2L, 3L);
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1L, 2L, 3L}).startsWith(2L, 3L));
    }

    @Test
    void endsWith() {
        assertThat(new long[]{1L, 2L, 3L, 4, 5}).endsWith(3L, 4L, 5L);
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1L, 2L, 3L}).endsWith(3L, 1L));
    }

    @Test
    void doesNotHaveDuplicates() {
        assertThat(new long[]{1L, 2L, 3L, 4, 5}).doesNotHaveDuplicates();
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1, 1, 1}).doesNotHaveDuplicates());
    }

    @Test
    void isSorted() {
        assertThat(new long[]{1L, 2L, 3L, 4, 5}).isSorted();
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1, 2, 6, 5}).isSorted());
    }

    @Test
    void isSortedBy() {
        assertThat(new long[]{1L, 2L, 3L, 4, 5}).isSortedBy((o1, o2) -> comparingLong(v -> (long) v).compare(o1, o2));
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1, 2, 5, 3}).isSortedBy((o1, o2) -> comparingLong(v -> (long) v).compare(o1, o2)));
    }

    @Test
    void isUnsorted() {
        assertThat(new long[]{2, 5, 3}).isUnsorted();
        assertThrows(AssertionError.class, () -> assertThat(new long[]{1L, 2L, 3L}).isUnsorted());
    }

}