package de.toberkoe.fluentassertions.api;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Factory class for type-specific assertions.
 *
 * @author t.bertram-koehler
 */
public class Assertions {

    private Assertions() {}

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
     * @return instance of assertion object
     */
    public static OptionalAssert assertThat(Optional<?> actual) {
        return new OptionalAssert(actual);
    }

    /**
     * Creates an instance of {@link CollectionAssert}.
     *
     * @param collection the value to be asserted
     * @return instance of assertion object
     */
    public static CollectionAssert assertThat(Collection collection) {
        return new CollectionAssert(collection);
    }

    /**
     * Creates an instance of {@link ListAssert}.
     *
     * @param collection the value to be asserted
     * @return instance of assertion object
     */
    public static <E> ListAssert<E> assertThat(List<E> collection) {
        return new ListAssert<>(collection);
    }

    /**
     * Creates an instance of {@link SetAssert}.
     *
     * @param collection the value to be asserted
     * @return instance of assertion object
     */
    public static <E> SetAssert<E> assertThat(Set<E> collection) {
        return new SetAssert<>(collection);
    }
}
