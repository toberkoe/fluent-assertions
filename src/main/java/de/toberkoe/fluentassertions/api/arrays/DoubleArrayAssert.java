package de.toberkoe.fluentassertions.api.arrays;

public class DoubleArrayAssert extends AbstractArrayAssert<DoubleArrayAssert, Double> {

    public DoubleArrayAssert(Double[] value) {
        super(value);
    }

    public DoubleArrayAssert(double[] value) {
        this(toObjectArray(value));
    }

    private static Double[] toObjectArray(double[] array) {
        Double[] objectArray = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            objectArray[i] = array[i];
        }
        return objectArray;
    }

    public DoubleArrayAssert hasSameSizeAs(double[] expectedSize) {
        new DoubleArrayAssert(expectedSize).isNotNull();
        return hasSizeOf(expectedSize.length);
    }
}
