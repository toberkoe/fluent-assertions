package de.toberkoe.fluentassertions.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.util.stream.Collectors.joining;

/**
 * Abstract {@code Object} Assertions.
 *
 * @author t.bertram-koehler
 */
public abstract class AbstractObjectAssert<S extends AbstractObjectAssert<S, T>, T> {

    protected final T value;
    protected final S instance;

    protected AbstractObjectAssert(T value) {
        this.value = value;
        instance = (S) this;
    }

    public S isNull() {
        if (test(Objects::isNull)) {
            return instance;
        }
        throw error("Expected to be null but was %s", value);
    }

    public S isNotNull() {
        if (!test(Objects::isNull)) {
            return instance;
        }
        throw error("Expected to be not null");
    }

    public S isEqualTo(T expected) {
        if (test(v -> Objects.equals(v, expected))) {
            return instance;
        }

        if (value == null) {
            throw error("Expected to be %s but was null", expected);
        } else {
            throw error("Expected to be %s but was %s", expected, value);
        }
    }

    public S isNotEqualTo(T expected) {
        if (!test(v -> Objects.equals(v, expected))) {
            return instance;
        }

        throw error("Expected to be not equal to %s", expected);
    }

    public S isSameAs(T expected) {
        if (test(v -> v == expected)) {
            return instance;
        }

        throw error("Expected to be the same as %s but was %s", expected, value);
    }

    public S isNotSameAs(T expected) {
        if (test(v -> v != expected)) {
            return instance;
        }

        throw error("Expected to be not the same as %s", expected);
    }

    public S isInstanceOf(Class<?> expectedClass) {
        if (test(expectedClass::isInstance)) {
            return instance;
        }

        throw error("Expected %s to be instance of %s", expectedClass.getName(), value);
    }

    public S isNotInstanceOf(Class<?> expectedClass) {
        if (!test(expectedClass::isInstance)) {
            return instance;
        }

        throw error("Expected %s to be not an instance of %s", expectedClass.getName(), value);
    }

    public S isInstanceOfAny(Class<?>... expectedClasses) {
        if (Stream.of(expectedClasses).anyMatch(cl -> cl.isInstance(value))) {
            return instance;
        }
        throw errorInstanceOfAny("Expected %s to be an instance of ", expectedClasses);
    }

    public S isNotInstanceOfAny(Class<?>... expectedClasses) {
        if (Stream.of(expectedClasses).noneMatch(cl -> cl.isInstance(value))) {
            return instance;
        }
        throw errorInstanceOfAny("Expected %s to be not an instance of ", expectedClasses);
    }

    private AssertionError errorInstanceOfAny(String message, Class<?>... classes) {
        message += Stream.of(classes).map(cl -> "%s").collect(joining(", "));

        List<Object> objects = new ArrayList<>();
        objects.add(value);
        Stream.of(classes).map(Class::getName).forEach(objects::add);
        throw error(message, objects.toArray(new Object[objects.size()]));
    }

    protected boolean test(Predicate<T> predicate) {
        return testCombined(predicate);
    }

    @SafeVarargs
    private boolean testCombined(Predicate<T>... predicates) {
        return Stream.of(predicates).allMatch(p -> p.test(value));
    }

    @SafeVarargs
    protected final boolean test(Predicate<T>... predicates) {
        return Stream.of(predicates).anyMatch(p -> p.test(value));
    }

    @SafeVarargs
    protected final AssertionError error(String message, Object... objects) {
        if (objects != null) {
            message = format(message, Stream.of(objects)
                    .map(this::formatObject).toArray(String[]::new));
        }
        return new AssertionError(message);
    }

    protected String formatObject(Object object) {
        return object.toString();
    }
}