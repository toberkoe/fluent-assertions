package de.toberkoe.fluentassertions.api.arrays;

import org.junit.jupiter.api.Test;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;
import static java.util.Comparator.comparingInt;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ObjectArrayAssertTest {

    @Test
    void isEmpty() {
        assertThat(new Object[]{}).isEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new Object[]{""}).isEmpty());
    }

    @Test
    void isNotEmpty() {
        assertThat(new Object[]{""}).isNotEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new Object[]{}).isNotEmpty());
    }

    @Test
    void isNullOrEmpty() {
        assertThat(new Object[]{}).isNullOrEmpty();
        assertThat((Object[]) null).isNullOrEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new Object[]{""}).isNullOrEmpty());
    }

    @Test
    void hasSizeOf() {
        assertThat(new Object[]{""}).hasSizeOf(1);
        assertThrows(AssertionError.class, () -> assertThat(new Object[]{""}).hasSizeOf(0));
    }

    @Test
    void hasSameSizeAs() {
        assertThat(new Object[]{""}).hasSameSizeAs(new Object[] {1});
        assertThrows(AssertionError.class, () -> assertThat(new Object[]{""}).hasSameSizeAs(null));
        assertThrows(AssertionError.class, () -> assertThat(new Object[]{""}).hasSameSizeAs(new Object[]{}));
        assertThrows(AssertionError.class, () -> assertThat(new Object[]{""}).hasSameSizeAs(new Object[]{1, 2}));
    }

    @Test
    void contains() {
        assertThat(new Object[] {"abc"}).contains("abc");
        assertThrows(AssertionError.class, () -> assertThat(new Object[] {"abc"}).contains("1"));
    }

    @Test
    void doesNotContain() {
        assertThat(new Object[] {"abc"}).doesNotContain("1");
        assertThrows(AssertionError.class, () -> assertThat(new Object[] {"abc"}).doesNotContain("abc"));
    }

    @Test
    void containsNull() {
        assertThat(new Object[] {"abc", null}).containsNull();
        assertThrows(AssertionError.class, () -> assertThat(new Object[] {"abc"}).containsNull());
    }

    @Test
    void doesNotContainNull() {
        assertThat(new Object[] {"abc"}).doesNotContainNull();
        assertThrows(AssertionError.class, () -> assertThat(new Object[] {"abc", null}).doesNotContainNull());
    }

    @Test
    void containsOnly() {
        assertThat(new Object[] {"a", "b", "c"}).containsOnly("a", "b", "c");
        assertThrows(AssertionError.class, () -> assertThat(new Object[] {"a", "b", "c"}).containsOnly(1, 2, 3));
    }

    @Test
    void containsAllOf() {
        assertThat(new Object[] {"a", "b", "c", "d", "e"}).containsAllOf("a", "b");
        assertThrows(AssertionError.class, () -> assertThat(new Object[] {"a", "b", "c"}).containsAllOf(1));
    }

    @Test
    void containsNoneOf() {
        assertThat(new Object[] {"a", "b", "c"}).containsNoneOf(1, 2, 3);
        assertThrows(AssertionError.class, () -> assertThat(new Object[] {"a", "b", "c"}).containsNoneOf(1, "a"));
    }

    @Test
    void containsSequence() {
        assertThat(new Object[] {1, 2, 3, 4, 5}).containsSequence(2, 3, 4);
        assertThrows(AssertionError.class, () -> assertThat(new Object[] {1, 2, 3, 4}).containsSequence(3, 2));
    }

    @Test
    void startsWith() {
        assertThat(new Object[] {1, 2, 3, 4, 5}).startsWith(1, 2, 3);
        assertThrows(AssertionError.class, () -> assertThat(new Object[] {1, 2, 3}).startsWith(2, 3));
    }

    @Test
    void endsWith() {
        assertThat(new Object[] {1, 2, 3, 4, 5}).endsWith(3, 4, 5);
        assertThrows(AssertionError.class, () -> assertThat(new Object[] {1, 2, 3}).endsWith(3, 1));
    }

    @Test
    void doesNotHaveDuplicates() {
        assertThat(new Object[] {1, 2, 3, 4, 5}).doesNotHaveDuplicates();
        assertThrows(AssertionError.class, () -> assertThat(new Object[] {1, 1, 1}).doesNotHaveDuplicates());
    }

    @Test
    void isSorted() {
        assertThat(new Object[]{1, 2, 3, 4, 5}).isSorted();
        assertThrows(AssertionError.class, () -> assertThat(new Object[]{1, 2, 6, 5}).isSorted());
    }

    @Test
    void isSortedBy() {
        assertThat(new String[]{"a", "ab", "abc"}).isSortedBy(comparingInt(String::length));
        assertThat(new String[]{"a", "ab", "abc"}).isSortedBy(String::length, String::length);
        assertThrows(AssertionError.class, () -> assertThat(new Object[]{"ab", "a", "abc"}).isSortedBy(o -> o.toString().length()));
    }

    @Test
    void isUnsorted() {
        assertThat(new Object[]{2, 5, 3}).isUnsorted();
        assertThrows(AssertionError.class, () -> assertThat(new Object[]{1, 2, 3}).isUnsorted());
    }

}