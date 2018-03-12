package de.toberkoe.fluentassertions.api;

public class IntegerArrayAssert extends AbstractArrayAssert<IntegerArrayAssert, Integer> {

    protected IntegerArrayAssert(Integer[] value) {
        super(value);
    }

    protected IntegerArrayAssert(int[] value) {
        super(toObjectArray(value));
    }

    private static Integer[] toObjectArray(int[] array) {
        Integer[] objectArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            objectArray[i] = array[i];
        }
        return objectArray;
    }

    public IntegerArrayAssert hasSameSizeAs(int[] expectedSize) {
        new IntegerArrayAssert(expectedSize).isNotNull();
        return hasSizeOf(expectedSize.length);
    }
}
