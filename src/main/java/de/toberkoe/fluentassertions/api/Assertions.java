package de.toberkoe.fluentassertions.api;

import java.math.BigDecimal;
import java.util.*;

/**
 * Factory class for type-specific assertions.
 *
 * @author t.bertram-koehler
 */
public class Assertions {

    private Assertions() {
    }

    /**
     * Creates an instance of {@link StringAssert}.
     *
     * @param string the value to be asserted
     * @return instance of assertion object
     */
    public static StringAssert assertThat(String string) {
        return new StringAssert(string);
    }

    /**
     * Creates an instance of {@link IntegerAssert}.
     *
     * @param number the value to be asserted
     * @return instance of assertion object
     */
    public static IntegerAssert assertThat(Integer number) {
        return new IntegerAssert(number);
    }

    /**
     * Creates an instance of {@link BigDecimalAssert}.
     *
     * @param number the value to be asserted
     * @return instance of assertion object
     */
    public static BigDecimalAssert assertThat(BigDecimal number) {
        return new BigDecimalAssert(number);
    }

    /**
     * Creates an instance of {@link DoubleAssert}.
     *
     * @param number the value to be asserted
     * @return instance of assertion object
     */
    public static DoubleAssert assertThat(Double number) {
        return new DoubleAssert(number);
    }

    /**
     * Creates an instance of {@link LongAssert}.
     *
     * @param number the value to be asserted
     * @return instance of assertion object
     */
    public static LongAssert assertThat(Long number) {
        return new LongAssert(number);
    }

    /**
     * Creates an instance of {@link FloatAssert}.
     *
     * @param number the value to be asserted
     * @return instance of assertion object
     */
    public static FloatAssert assertThat(Float number) {
        return new FloatAssert(number);
    }

    /**
     * Creates an instance of {@link ShortAssert}.
     *
     * @param number the value to be asserted
     * @return instance of assertion object
     */
    public static ShortAssert assertThat(Short number) {
        return new ShortAssert(number);
    }

    /**
     * Creates an instance of {@link ObjectAssert}.
     *
     * @param object the value to be asserted
     * @return instance of assertion object
     */
    public static ObjectAssert assertThat(Object object) {
        return new ObjectAssert(object);
    }

    /**
     * Creates an instance of {@link BooleanAssert}.
     *
     * @param actual the value to be asserted
     * @return instance of assertion object
     */
    public static BooleanAssert assertThat(Boolean actual) {
        return new BooleanAssert(actual);
    }

    /**
     * Creates an instance of {@link OptionalAssert}.
     *
     * @param actual the value to be asserted
     * @param <E>    type of optional value
     * @return instance of assertion object
     */
    public static <E> OptionalAssert<E> assertThat(Optional<E> actual) {
        return new OptionalAssert<>(actual);
    }

    /**
     * Creates an instance of {@link CollectionAssert}.
     *
     * @param collection the value to be asserted
     * @param <E>        type of value
     * @return instance of assertion object
     */
    public static <E> CollectionAssert<E> assertThat(Collection<E> collection) {
        return new CollectionAssert<>(collection);
    }

    /**
     * Creates an instance of {@link ListAssert}.
     *
     * @param collection the value to be asserted
     * @param <E>        type of value
     * @return instance of assertion object
     */
    public static <E> ListAssert<E> assertThat(List<E> collection) {
        return new ListAssert<>(collection);
    }

    /**
     * Creates an instance of {@link SetAssert}.
     *
     * @param collection the value to be asserted
     * @param <E>        type of value
     * @return instance of assertion object
     */
    public static <E> SetAssert<E> assertThat(Set<E> collection) {
        return new SetAssert<>(collection);
    }

    /**
     * Creates an instance of {@link MapAssert}.
     *
     * @param collection the value to be asserted
     * @param <K>        type of key
     * @param <V>        type of value
     * @return instance of assertion object
     */
    public static <K, V> MapAssert<K, V> assertThat(Map<K, V> collection) {
        return new MapAssert<>(collection);
    }

    /**
     * Creates an instance of {@link ThrowableAssert}.
     *
     * @param throwable the value to be asserted
     * @return instance of assertion object
     */
    public static ThrowableAssert assertThat(Throwable throwable) {
        return new ThrowableAssert(throwable);
    }

    /**
     * Creates an instance of {@link ObjectArrayAssert}.
     *
     * @param array the value to be asserted
     * @return instance of assertion object
     */
    public static ObjectArrayAssert assertThat(Object[] array) {
        return new ObjectArrayAssert(array);
    }

    /**
     * Creates an instance of {@link BooleanArrayAssert}.
     *
     * @param array the value to be asserted
     * @return instance of assertion object
     */
    public static BooleanArrayAssert assertThat(boolean[] array) {
        return new BooleanArrayAssert(array);
    }

    /**
     * Creates an instance of {@link IntegerArrayAssert}.
     *
     * @param array the value to be asserted
     * @return instance of assertion object
     */
    public static IntegerArrayAssert assertThat(int[] array) {
        return new IntegerArrayAssert(array);
    }

}
