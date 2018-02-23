package de.toberkoe.fluentassertions.api;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CollectionAssertTest {

    @Test
    void testIsEmpty() {
        Assertions.assertThat(List.of()).isEmpty();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of(1)).isEmpty());
    }

    @Test
    void testIsNotEmpty() {
        Assertions.assertThat(List.of(1)).isNotEmpty();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of()).isNotEmpty());
    }

    @Test
    void testIsNullOrEmpty() {
        Assertions.assertThat((List) null).isNullOrEmpty();
        Assertions.assertThat(List.of()).isNullOrEmpty();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of(1)).isNullOrEmpty());
    }

    @Test
    void testHasSizeOf() {
        Assertions.assertThat(List.of(1)).hasSizeOf(1);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of()).hasSizeOf(1));
    }

    @Test
    void testHasSameSizeAs() {
        Assertions.assertThat(List.of(1)).hasSameSizeAs(List.of(""));
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of()).hasSameSizeAs(List.of("")));
    }

    @Test
    void testContains() {
        Assertions.assertThat(List.of(1)).contains(1);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of()).contains(1));
    }

    @Test
    void testDoesNotContain() {
        Assertions.assertThat(List.of(1)).doesNotContain(2);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of(1)).doesNotContain(1));
    }

    @Test
    void testContainsNull() {
        List<?> list = new ArrayList<>();
        list.add(null);
        Assertions.assertThat(list).containsNull();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of(1)).containsNull());
    }

    @Test
    void testDoesNotContainNull() {
        Assertions.assertThat(List.of(1)).doesNotContainNull();

        List<?> list = new ArrayList<>();
        list.add(null);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(list).doesNotContainNull());
    }

    @Test
    void testContainsOnly() {
        Assertions.assertThat(List.of(1, 2, 3)).containsOnly(1, 2, 3);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of(1)).containsOnly(2));
    }

    @Test
    void testContainsAllOf() {
        Assertions.assertThat(List.of(1, 2, 3)).containsAllOf(1, 2);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of(1, 2, 3)).containsAllOf(2, 4));
    }

    @Test
    void testContainsNoneOf() {
        Assertions.assertThat(List.of(1, 2, 3)).containsNoneOf(4, 5);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of(1, 2, 3)).containsNoneOf(2, 4));
    }

    @Test
    void testContainsSequence() {
        Assertions.assertThat(List.of(1, 2, 3, 4, 5)).containsSequence(2, 3);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of(1, 2, 3)).containsSequence(4, 5));
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of(1, 2, 3, 4, 5)).containsSequence(2, 4, 3, 5));
    }

    @Test
    void testStartsWith() {
        Assertions.assertThat(List.of(1, 2, 3, 4, 5)).startsWith(1, 2, 3);
        Assertions.assertThat(List.of(1, 2, 3)).startsWith(1, 2, 3);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of(1, 2, 3)).startsWith(4, 5));
    }

    @Test
    void testEndsWith() {
        Assertions.assertThat(List.of(1, 2, 3, 4, 5)).endsWith(4, 5);
        Assertions.assertThat(List.of(1, 2, 3)).endsWith(1, 2, 3);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of(1, 2, 3)).endsWith(4, 5));
    }

    @Test
    void testDoesNotHaveDuplicates() {
        Assertions.assertThat(List.of(1, 2, 3, 4, 5)).doesNotHaveDuplicates();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(List.of(1, 1, 1)).doesNotHaveDuplicates());
    }
}