package de.toberkoe.fluentassertions.api;

public class LongArrayAssert extends AbstractArrayAssert<LongArrayAssert, Long> {

    protected LongArrayAssert(Long[] value) {
        super(value);
    }

    protected LongArrayAssert(long[] value) {
        super(toObjectArray(value));
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
