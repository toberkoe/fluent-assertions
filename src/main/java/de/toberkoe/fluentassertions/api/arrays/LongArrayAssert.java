package de.toberkoe.fluentassertions.api.arrays;

public class LongArrayAssert extends AbstractArrayAssert<LongArrayAssert, Long> {

    public LongArrayAssert(Long[] value) {
        super(value);
    }

    public LongArrayAssert(long[] value) {
        this(toObjectArray(value));
    }

    private static Long[] toObjectArray(long[] array) {
        Long[] objectArray = new Long[array.length];
        for (int i = 0; i < array.length; i++) {
            objectArray[i] = array[i];
        }
        return objectArray;
    }

    public LongArrayAssert hasSameSizeAs(long[] expectedSize) {
        new LongArrayAssert(expectedSize).isNotNull();
        return hasSizeOf(expectedSize.length);
    }
}
