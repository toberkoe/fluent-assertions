package de.toberkoe.fluentassertions.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapAssertTest {

    private Map<Integer, String> empty = Map.of();
    private Map<Integer, String> entries = Map.of(1, "A", 2, "B", 3, "C");
    private MapAssert<Integer, String> test;

    @BeforeEach
    void init() {
        test = Assertions.assertThat(entries);
    }

    @Test
    void testContainsKey() {
        test.containsKey(1);
        assertThrows(AssertionError.class, () -> test.containsKey(0));
    }

    @Test
    void testDoesNotContainKey() {
        test.doesNotContainKey(0);
        assertThrows(AssertionError.class, () -> test.doesNotContainKey(1));
    }

    @Test
    void testContainsValue() {
        test.containsValue("A");
        assertThrows(AssertionError.class, () -> test.containsValue("X"));
    }

    @Test
    void testDoesNotContainValue() {
        test.doesNotContainValue("X");
        assertThrows(AssertionError.class, () -> test.doesNotContainValue("A"));
    }

    @Test
    void testContains() {
        test.contains(Map.entry(1, "A"));
        test.contains(1, "A");
        assertThrows(AssertionError.class, () -> test.contains(Map.entry(2, "X")));
    }

    @Test
    void testDoesNotContain() {
        test.doesNotContain(Map.entry(1, "X"));
        assertThrows(AssertionError.class, () -> test.doesNotContain(Map.entry(1, "A")));
    }

    @Test
    void testHasSizeOf() {
        test.hasSizeOf(3);
        assertThrows(AssertionError.class, () -> test.hasSizeOf(2));
    }

    @Test
    void testHasKeySizeOf() {
        test.hasKeySizeOf(3);
        assertThrows(AssertionError.class, () -> test.hasKeySizeOf(2));
    }

    @Test
    void testHasValueSizeOf() {
        test.hasValueSizeOf(3);
        assertThrows(AssertionError.class, () -> test.hasValueSizeOf(2));
    }

    @Test
    void testHasSameSizeAs() {
        test.hasSameSizeAs(entries);
        assertThrows(AssertionError.class, () -> test.hasSameSizeAs(empty));
    }

    @Test
    void testIsEmpty() {
        Assertions.assertThat(empty).isEmpty();
        assertThrows(AssertionError.class, () -> test.isEmpty());
    }

    @Test
    void testIsNotEmpty() {
        test.isNotEmpty();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(empty).isNotEmpty());
    }

    @Test
    void testIsNullOrEmpty() {
        Assertions.assertThat(empty).isNullOrEmpty();
        Assertions.assertThat((Map) null).isNullOrEmpty();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(entries).isNullOrEmpty());
    }

    @Test
    void testIsNull() {
        Assertions.assertThat((Map) null).isNull();
        assertThrows(AssertionError.class, () -> test.isNull());
    }

    @Test
    void testIsNotNull() {
        test.isNotNull();
        assertThrows(AssertionError.class, () -> Assertions.assertThat((Map) null).isNotNull());
    }

    @Test
    void testIsEqualTo() {
        test.isEqualTo(entries);
        assertThrows(AssertionError.class, () -> test.isEqualTo(empty));
    }

    @Test
    void testIsNotEqualTo() {
        test.isNotEqualTo(empty);
        assertThrows(AssertionError.class, () -> test.isNotEqualTo(entries));
    }

    @Test
    void testIsSameAs() {
        test.isSameAs(entries);
        assertThrows(AssertionError.class, () -> test.isEqualTo(empty));
    }

    @Test
    void testIsNotSameAs() {
        test.isNotSameAs(empty);
        assertThrows(AssertionError.class, () -> test.isNotSameAs(entries));
    }

    @Test
    void testIsInstanceOf() {
        test.isInstanceOf(Map.class);
        assertThrows(AssertionError.class, () -> test.isInstanceOf(String.class));
    }

    @Test
    void testIsNotInstanceOf() {
        test.isNotInstanceOf(String.class);
        assertThrows(AssertionError.class, () -> test.isNotInstanceOf(Map.class));
    }

    @Test
    void testIsInstanceOfAny() {
        test.isInstanceOfAny(Map.class);
        assertThrows(AssertionError.class, () -> test.isInstanceOfAny(String.class));
    }

    @Test
    void testIsNotInstanceOfAny() {
        test.isNotInstanceOfAny(String.class);
        assertThrows(AssertionError.class, () -> test.isNotInstanceOfAny(Map.class));
    }

    @Test
    void testContainsOnly() {
        test.containsOnly(Map.entry(1, "A"), Map.entry(2, "B"), Map.entry(3, "C"));
        assertThrows(AssertionError.class, () -> test.containsOnly(Map.entry(1, "A")));
    }

    @Test
    void testContainsAllOf() {
        test.containsAllOf(Map.entry(1, "A"), Map.entry(2, "B"), Map.entry(3, "C"));
        assertThrows(AssertionError.class, () -> test.containsAllOf(Map.entry(0, "A")));
    }

    @Test
    void testContainsNoneOf() {
        test.containsNoneOf(Map.entry(0, "X"));
        assertThrows(AssertionError.class, () -> test.containsNoneOf(Map.entry(1, "A")));
    }

    @Test
    void testDoesNotHaveDuplicatedValues() {
        test.doesNotHaveDuplicatedValues();

        Map<Integer, String> map = Map.of(1, "A", 2, "A");
        assertThrows(AssertionError.class, () -> Assertions.assertThat(map).doesNotHaveDuplicatedValues());
    }
}