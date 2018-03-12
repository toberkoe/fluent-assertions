package de.toberkoe.fluentassertions.api.arrays;

public class BooleanArrayAssert extends AbstractArrayAssert<BooleanArrayAssert, Boolean> {

    public BooleanArrayAssert(Boolean[] value) {
        super(value);
    }

    public BooleanArrayAssert(boolean[] value) {
        super(toObjectArray(value));
    }

    private static Boolean[] toObjectArray(boolean[] array) {
        Boolean[] objectArray = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            objectArray[i] = array[i];
        }
        return objectArray;
    }

    public BooleanArrayAssert hasSameSizeAs(boolean[] expectedSize) {
        new BooleanArrayAssert(expectedSize).isNotNull();
        return hasSizeOf(expectedSize.length);
    }
}
