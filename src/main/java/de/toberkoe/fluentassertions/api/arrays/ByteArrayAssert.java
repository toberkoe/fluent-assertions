package de.toberkoe.fluentassertions.api.arrays;

public class ByteArrayAssert extends AbstractArrayAssert<ByteArrayAssert, Byte> {

    protected ByteArrayAssert(Byte[] value) {
        super(value);
    }

    public ByteArrayAssert(byte[] value) {
        this(toObjectArray(value));
    }

    private static Byte[] toObjectArray(byte[] array) {
        Byte[] objectArray = new Byte[array.length];
        for (int i = 0; i < array.length; i++) {
            objectArray[i] = array[i];
        }
        return objectArray;
    }

    public ByteArrayAssert hasSameSizeAs(byte[] expectedSize) {
        new ByteArrayAssert(expectedSize).isNotNull();
        return hasSizeOf(expectedSize.length);
    }
}
