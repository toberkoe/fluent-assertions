package de.toberkoe.fluentassertions.api.arrays;

import org.junit.jupiter.api.Test;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class BooleanArrayAssertTest {

    @Test
    void isEmpty() {
        assertThat(new boolean[]{}).isEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{false}).isEmpty());
    }

    @Test
    void isNotEmpty() {
        assertThat(new boolean[]{false}).isNotEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{}).isNotEmpty());
    }

    @Test
    void isNullOrEmpty() {
        assertThat(new boolean[]{}).isNullOrEmpty();
        assertThat((Object[]) null).isNullOrEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{false}).isNullOrEmpty());
    }

    @Test
    void hasSizeOf() {
        assertThat(new boolean[]{false}).hasSizeOf(1);
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{false}).hasSizeOf(0));
    }

    @Test
    void hasSameSizeAs() {
        assertThat(new boolean[]{false}).hasSameSizeAs(new boolean[]{false});
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{false}).hasSameSizeAs(new boolean[]{}));
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{}).hasSameSizeAs(new boolean[]{false}));
    }

    @Test
    void contains() {
        assertThat(new boolean[]{false}).contains(false);
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{true}).contains(false));
    }

    @Test
    void doesNotContain() {
        assertThat(new boolean[]{true}).doesNotContain(false);
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{false}).doesNotContain(false));
    }

    @Test
    void containsNull() {
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{false}).containsNull());
    }

    @Test
    void doesNotContainNull() {
        assertThat(new boolean[]{false}).doesNotContainNull();
    }

    @Test
    void containsOnly() {
        assertThat(new boolean[]{true}).containsOnly(true);
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{true}).containsOnly(false));
    }

    @Test
    void containsAllOf() {
        assertThat(new boolean[]{true, false}).containsAllOf(true, false);
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{true}).containsAllOf(false));
    }

    @Test
    void containsNoneOf() {
        assertThat(new boolean[]{true}).containsNoneOf(false);
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{true}).containsNoneOf(true));
    }

    @Test
    void containsSequence() {
        assertThat(new boolean[]{true, false, false, true}).containsSequence(false, false, true);
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{true, false}).containsSequence(false, true));
    }

    @Test
    void startsWith() {
        assertThat(new boolean[]{true, false, true, false}).startsWith(true, false, true);
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{true, true}).startsWith(false));
    }

    @Test
    void endsWith() {
        assertThat(new boolean[]{true, true, true, false}).endsWith(true, true, false);
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{true, false}).endsWith(true));
    }

    @Test
    void doesNotHaveDuplicates() {
        assertThat(new boolean[]{true, false}).doesNotHaveDuplicates();
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{true, true}).doesNotHaveDuplicates());
    }

    @Test
    void isSorted() {
        assertThat(new boolean[]{false, true}).isSorted();
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{true, false}).isSorted());
    }

    @Test
    void isUnsorted() {
        assertThat(new boolean[]{true, false}).isUnsorted();
        assertThrows(AssertionError.class, () -> assertThat(new boolean[]{false, true}).isUnsorted());
    }

}