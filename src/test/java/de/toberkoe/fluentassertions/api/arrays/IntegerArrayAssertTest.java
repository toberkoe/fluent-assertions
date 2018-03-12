package de.toberkoe.fluentassertions.api.arrays;

import org.junit.jupiter.api.Test;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;
import static java.util.Comparator.comparingInt;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerArrayAssertTest {

    @Test
    void isEmpty() {
        assertThat(new int[]{}).isEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1}).isEmpty());
    }

    @Test
    void isNotEmpty() {
        assertThat(new int[]{1}).isNotEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new int[]{}).isNotEmpty());
    }

    @Test
    void isNullOrEmpty() {
        assertThat(new int[]{}).isNullOrEmpty();
        assertThat((Object[]) null).isNullOrEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1}).isNullOrEmpty());
    }

    @Test
    void hasSizeOf() {
        assertThat(new int[]{1}).hasSizeOf(1);
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1}).hasSizeOf(0));
    }

    @Test
    void hasSameSizeAs() {
        assertThat(new int[]{1}).hasSameSizeAs(new int[]{1});
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1}).hasSameSizeAs(new int[]{}));
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1}).hasSameSizeAs(new int[]{1, 2}));
    }

    @Test
    void contains() {
        assertThat(new int[]{1}).contains(1);
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1}).contains(2));
    }

    @Test
    void doesNotContain() {
        assertThat(new int[]{1}).doesNotContain(2);
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1}).doesNotContain(1));
    }

    @Test
    void containsNull() {
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1}).containsNull());
    }

    @Test
    void doesNotContainNull() {
        assertThat(new int[]{1}).doesNotContainNull();
    }

    @Test
    void containsOnly() {
        assertThat(new int[]{1, 2, 3}).containsOnly(1, 2, 3);
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1, 2, 3, 4, 5}).containsOnly(1, 2, 3));
    }

    @Test
    void containsAllOf() {
        assertThat(new int[]{1, 2, 3, 4, 5}).containsAllOf(1, 2);
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1, 2, 3}).containsAllOf(1, 5));
    }

    @Test
    void containsNoneOf() {
        assertThat(new int[]{1, 2, 3}).containsNoneOf(4, 5);
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1, 2, 3}).containsNoneOf(1, 2));
    }

    @Test
    void containsSequence() {
        assertThat(new int[]{1, 2, 3, 4, 5}).containsSequence(2, 3, 4);
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1, 2, 3, 4}).containsSequence(3, 2));
    }

    @Test
    void startsWith() {
        assertThat(new int[]{1, 2, 3, 4, 5}).startsWith(1, 2, 3);
        assertThat(new int[]{1, 2, 3}).startsWith(1, 2, 3);
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1, 2, 3}).startsWith(2, 3));
    }

    @Test
    void endsWith() {
        assertThat(new int[]{1, 2, 3, 4, 5}).endsWith(3, 4, 5);
        assertThat(new int[]{3, 4, 5}).endsWith(3, 4, 5);
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1, 2, 3}).endsWith(3, 1));
    }

    @Test
    void doesNotHaveDuplicates() {
        assertThat(new int[]{1, 2, 3, 4, 5}).doesNotHaveDuplicates();
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1, 1, 1}).doesNotHaveDuplicates());
    }

    @Test
    void isSorted() {
        assertThat(new int[]{1, 2, 3, 4, 5}).isSorted();
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1, 2, 6, 5}).isSorted());
    }

    @Test
    void isSortedBy() {
        assertThat(new int[]{1, 2, 3, 4, 5}).isSortedBy((o1, o2) -> comparingInt(v -> (int) v).compare(o1, o2));
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1, 2, 5, 3}).isSortedBy((o1, o2) -> comparingInt(v -> (int) v).compare(o1, o2)));
    }

    @Test
    void isUnsorted() {
        assertThat(new int[]{2, 5, 3}).isUnsorted();
        assertThrows(AssertionError.class, () -> assertThat(new int[]{1, 2, 3}).isUnsorted());
    }

}