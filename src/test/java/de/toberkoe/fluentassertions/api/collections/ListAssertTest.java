package de.toberkoe.fluentassertions.api.collections;

import de.toberkoe.fluentassertions.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Comparator.comparing;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ListAssertTest {

    private List<Integer> nullList = null;
    private List<Integer> empty = List.of();
    private List<Integer> entries = List.of(1, 2, 3, 4, 5);
    private List<Integer> otherEntries = List.of(8, 9, 10);

    @Test
    void testIsEmpty() {
        Assertions.assertThat(empty).isEmpty();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).isEmpty());
    }

    @Test
    void testIsNotEmpty() {
        Assertions.assertThat(entries).isNotEmpty();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(empty).isNotEmpty());
    }

    @Test
    void testIsNullOrEmpty() {
        Assertions.assertThat(nullList).isNullOrEmpty();
        Assertions.assertThat(empty).isNullOrEmpty();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).isNullOrEmpty());
    }

    @Test
    void testHasSizeOf() {
        Assertions.assertThat(entries).hasSizeOf(5);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(empty).hasSizeOf(1));
    }

    @Test
    void testHasSameSizeAs() {
        Assertions.assertThat(entries).hasSameSizeAs(entries);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(empty).hasSameSizeAs(entries));
    }

    @Test
    void testContains() {
        Assertions.assertThat(entries).contains(1);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).contains(10));
    }

    @Test
    void testDoesNotContain() {
        Assertions.assertThat(entries).doesNotContain(10);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).doesNotContain(1));
    }

    @Test
    void testContainsNull() {
        Set<Integer> containingNull = new HashSet<>();
        containingNull.add(null);
        Assertions.assertThat(containingNull).containsNull();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).containsNull());
    }

    @Test
    void testDoesNotContainNull() {
        Set<Integer> containingNull = new HashSet<>();
        containingNull.add(null);
        Assertions.assertThat(entries).doesNotContainNull();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(containingNull).doesNotContainNull());
    }

    @Test
    void testContainsOnly() {
        Assertions.assertThat(entries).containsOnly(1, 2, 3, 4, 5);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).containsOnly(8, 9, 10));
    }

    @Test
    void testContainsAllOf() {
        Assertions.assertThat(entries).containsAllOf(1, 2, 3);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).containsAllOf(8, 9, 10));
    }

    @Test
    void testContainsNoneOf() {
        Assertions.assertThat(entries).containsNoneOf(6, 7, 8);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).containsAllOf(5, 6, 7));
    }

    @Test
    void testContainsSequence() {
        Assertions.assertThat(entries).containsSequence(2, 3, 4);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).containsSequence(2, 4, 3));
    }

    @Test
    void testStartsWith() {
        Assertions.assertThat(entries).startsWith(1, 2, 3);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).startsWith(8, 9, 10));
    }

    @Test
    void testEndsWith() {
        Assertions.assertThat(entries).endsWith(4, 5);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).endsWith(8, 9, 10));
    }

    @Test
    void testDoesNotHaveDuplicates() {
        Assertions.assertThat(entries).doesNotHaveDuplicates();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of(1, 1, 1)).doesNotHaveDuplicates());
    }

    @Test
    void testIsNull() {
        Assertions.assertThat(nullList).isNull();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).isNull());
    }

    @Test
    void testIsNotNull() {
        Assertions.assertThat(entries).isNotNull();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(nullList).isNotNull());
    }

    @Test
    void testIsEqualTo() {
        Assertions.assertThat(entries).isEqualTo(entries);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).isEqualTo(otherEntries));
    }

    @Test
    void testIsNotEqualTo() {
        Assertions.assertThat(entries).isNotEqualTo(otherEntries);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).isNotEqualTo(entries));
    }

    @Test
    void testIsSameAs() {
        Assertions.assertThat(entries).isSameAs(entries);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).isSameAs(otherEntries));
    }

    @Test
    void testIsNotSameAs() {
        Assertions.assertThat(entries).isNotSameAs(otherEntries);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).isNotSameAs(entries));
    }

    @Test
    void testIsInstanceOf() {
        Assertions.assertThat(entries).isInstanceOf(List.class);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).isInstanceOf(String.class));
    }

    @Test
    void testIsNotInstanceOf() {
        Assertions.assertThat(entries).isNotInstanceOf(String.class);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).isNotInstanceOf(List.class));
    }

    @Test
    void testIsInstanceOfAny() {
        Assertions.assertThat(entries).isInstanceOfAny(List.class);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).isInstanceOfAny(String.class));
    }

    @Test
    void testIsNotInstanceOfAny() {
        Assertions.assertThat(entries).isNotInstanceOfAny(String.class);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).isNotInstanceOfAny(List.class));
    }

    @Test
    void testIsSorted() {
        Assertions.assertThat(List.of(1, 2, 3, 4, 5)).isSorted();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of(2, 1, 3)).isSorted());
    }

    @Test
    void testIsSortedBy() {
        Assertions.assertThat(List.of("", "a", "ab", "abc")).isSortedBy(comparing(String::length));
        Assertions.assertThat(List.of("", "a", "ab", "abc")).isSortedBy(String::length);
        Assertions.assertThat(List.of("", "a", "ab", "abc")).isSortedBy(String::length, String::length);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of("ab", "c", "x")).isSortedBy(String::length));
    }

    @Test
    void testIsUnsorted() {
        Assertions.assertThat(List.of(1, 5, 3)).isUnsorted();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of(1, 2, 3)).isUnsorted());
    }
}