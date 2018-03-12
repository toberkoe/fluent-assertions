package de.toberkoe.fluentassertions.api.arrays;

import org.junit.jupiter.api.Test;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;
import static java.util.Comparator.comparingDouble;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ByteArrayAssertTest {

    @Test
    void isEmpty() {
        assertThat(new byte[]{}).isEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1}).isEmpty());
    }

    @Test
    void isNotEmpty() {
        assertThat(new byte[]{1}).isNotEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{}).isNotEmpty());
    }

    @Test
    void isNullOrEmpty() {
        assertThat(new byte[]{}).isNullOrEmpty();
        assertThat((Object[]) null).isNullOrEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1}).isNullOrEmpty());
    }

    @Test
    void hasSizeOf() {
        assertThat(new byte[]{1}).hasSizeOf(1);
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1}).hasSizeOf(0));
    }

    @Test
    void hasSameSizeAs() {
        assertThat(new byte[]{1}).hasSameSizeAs(new byte[]{1});
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1}).hasSameSizeAs(new byte[]{}));
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1}).hasSameSizeAs(new byte[]{1, 2}));
    }

    @Test
    void contains() {
        assertThat(new byte[]{1}).contains((byte) 1);
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1}).contains((byte) 2));
    }

    @Test
    void doesNotContain() {
        assertThat(new byte[]{1}).doesNotContain((byte) 2);
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1}).doesNotContain((byte) 1));
    }

    @Test
    void containsNull() {
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1}).containsNull());
    }

    @Test
    void doesNotContainNull() {
        assertThat(new byte[]{1}).doesNotContainNull();
    }

    @Test
    void containsOnly() {
        assertThat(new byte[]{1, 2, 3}).containsOnly((byte) 1, (byte) 2, (byte) 3);
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1, 2, 3, 4, 5}).containsOnly((byte) 1, (byte) 2, (byte) 3));
    }

    @Test
    void containsAllOf() {
        assertThat(new byte[]{1, 2, 3, 4, 5}).containsAllOf((byte) 1, (byte) 2);
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1, 2, 3}).containsAllOf((byte) 1, (byte) 5));
    }

    @Test
    void containsNoneOf() {
        assertThat(new byte[]{1, 2, 3}).containsNoneOf((byte) 4, (byte) 5);
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1, 2, 3}).containsNoneOf((byte) 1, (byte) 2));
    }

    @Test
    void containsSequence() {
        assertThat(new byte[]{1, 2, 3, 4, 5}).containsSequence((byte) 2, (byte) 3, (byte) 4);
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1, 2, 3, 4}).containsSequence((byte) 3, (byte) 2));
    }

    @Test
    void startsWith() {
        assertThat(new byte[]{1, 2, 3, 4, 5}).startsWith((byte) 1, (byte) 2, (byte) 3);
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1, 2, 3}).startsWith((byte) 2, (byte) 3));
    }

    @Test
    void endsWith() {
        assertThat(new byte[]{1, 2, 3, 4, 5}).endsWith((byte) 3, (byte) 4, (byte) 5);
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1, 2, 3}).endsWith((byte) 3, (byte) 1));
    }

    @Test
    void doesNotHaveDuplicates() {
        assertThat(new byte[]{1, 2, 3, 4, 5}).doesNotHaveDuplicates();
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1, 1, 1}).doesNotHaveDuplicates());
    }

    @Test
    void isSorted() {
        assertThat(new byte[]{1, 2, 3, 4, 5}).isSorted();
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1, 2, 6, 5}).isSorted());
    }

    @Test
    void isSortedBy() {
        assertThat(new byte[]{1, 2, 3, 4, 5}).isSortedBy((o1, o2) -> comparingDouble(v -> (byte) v).compare(o1, o2));
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1, 2, 5, 3}).isSortedBy((o1, o2) -> comparingDouble(v -> (byte) v).compare(o1, o2)));
    }

    @Test
    void isUnsorted() {
        assertThat(new byte[]{2, 5, 3}).isUnsorted();
        assertThrows(AssertionError.class, () -> assertThat(new byte[]{1, 2, 3}).isUnsorted());
    }

}