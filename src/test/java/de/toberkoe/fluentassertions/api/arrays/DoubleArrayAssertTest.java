package de.toberkoe.fluentassertions.api.arrays;

import org.junit.jupiter.api.Test;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;
import static java.util.Comparator.comparingDouble;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DoubleArrayAssertTest {

    @Test
    void isEmpty() {
        assertThat(new double[]{}).isEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1}).isEmpty());
    }

    @Test
    void isNotEmpty() {
        assertThat(new double[]{1}).isNotEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new double[]{}).isNotEmpty());
    }

    @Test
    void isNullOrEmpty() {
        assertThat(new double[]{}).isNullOrEmpty();
        assertThat((Object[]) null).isNullOrEmpty();
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1}).isNullOrEmpty());
    }

    @Test
    void hasSizeOf() {
        assertThat(new double[]{1}).hasSizeOf(1);
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1}).hasSizeOf(0));
    }

    @Test
    void hasSameSizeAs() {
        assertThat(new double[]{1}).hasSameSizeAs(new double[]{1});
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1}).hasSameSizeAs(new double[]{}));
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1}).hasSameSizeAs(new double[]{1, 2}));
    }

    @Test
    void contains() {
        assertThat(new double[]{1}).contains(1D);
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1}).contains(2D));
    }

    @Test
    void doesNotContain() {
        assertThat(new double[]{1}).doesNotContain(2D);
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1}).doesNotContain(1D));
    }

    @Test
    void containsNull() {
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1}).containsNull());
    }

    @Test
    void doesNotContainNull() {
        assertThat(new double[]{1}).doesNotContainNull();
    }

    @Test
    void containsOnly() {
        assertThat(new double[]{1D, 2D, 3D}).containsOnly(1D, 2D, 3D);
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1D, 2D, 3D, 4, 5}).containsOnly(1D, 2D, 3D));
    }

    @Test
    void containsAllOf() {
        assertThat(new double[]{1D, 2D, 3D, 4, 5}).containsAllOf(1D, 2D);
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1D, 2D, 3D}).containsAllOf(1D, 5D));
    }

    @Test
    void containsNoneOf() {
        assertThat(new double[]{1D, 2D, 3D}).containsNoneOf(4D, 5D);
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1D, 2D, 3D}).containsNoneOf(1D, 2D));
    }

    @Test
    void containsSequence() {
        assertThat(new double[]{1D, 2D, 3D, 4, 5}).containsSequence(2D, 3D, 4D);
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1D, 2D, 3D, 4}).containsSequence(3D, 2D));
    }

    @Test
    void startsWith() {
        assertThat(new double[]{1D, 2D, 3D, 4, 5}).startsWith(1D, 2D, 3D);
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1D, 2D, 3D}).startsWith(2D, 3D));
    }

    @Test
    void endsWith() {
        assertThat(new double[]{1D, 2D, 3D, 4, 5}).endsWith(3D, 4D, 5D);
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1D, 2D, 3D}).endsWith(3D, 1D));
    }

    @Test
    void doesNotHaveDuplicates() {
        assertThat(new double[]{1D, 2D, 3D, 4, 5}).doesNotHaveDuplicates();
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1, 1, 1}).doesNotHaveDuplicates());
    }

    @Test
    void isSorted() {
        assertThat(new double[]{1D, 2D, 3D, 4, 5}).isSorted();
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1, 2, 6, 5}).isSorted());
    }

    @Test
    void isSortedBy() {
        assertThat(new double[]{1D, 2D, 3D, 4, 5}).isSortedBy((o1, o2) -> comparingDouble(v -> (double) v).compare(o1, o2));
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1, 2, 5, 3}).isSortedBy((o1, o2) -> comparingDouble(v -> (double) v).compare(o1, o2)));
    }

    @Test
    void isUnsorted() {
        assertThat(new double[]{2, 5, 3}).isUnsorted();
        assertThrows(AssertionError.class, () -> assertThat(new double[]{1D, 2D, 3D}).isUnsorted());
    }

}