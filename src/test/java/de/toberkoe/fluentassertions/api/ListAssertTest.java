package de.toberkoe.fluentassertions.api;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Comparator.comparing;
import static org.junit.jupiter.api.Assertions.*;

class ListAssertTest {

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