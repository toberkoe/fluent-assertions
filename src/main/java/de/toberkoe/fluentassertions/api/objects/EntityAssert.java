package de.toberkoe.fluentassertions.api.objects;

import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Stream;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;
import static java.util.stream.Collectors.toList;

public class EntityAssert<E> extends AbstractObjectAssert<EntityAssert<E>, E> {

    public EntityAssert(E value) {
        super(value);
    }

    public EntityAssert<E> isIdZero() {
        return isIdEqualTo(0);
    }

    public EntityAssert<E> isIdNotZero() {
        return isIdNotEqualTo(0);
    }

    public EntityAssert<E> isIdPositive() {
        return isIdGreaterThan(0);
    }

    public EntityAssert<E> isIdNegative() {
        return isIdLessThan(0);
    }

    public EntityAssert<E> isIdGreaterThan(long value) {
        long id = getId();
        assertThat(id).isGreaterThan(value);
        return instance;
    }

    public EntityAssert<E> isIdGreaterThanOrEqualTo(long value) {
        long id = getId();
        assertThat(id).isGreaterThanOrEqualTo(value);
        return instance;
    }

    public EntityAssert<E> isIdLessThan(long value) {
        long id = getId();
        assertThat(id).isLessThan(value);
        return instance;
    }

    public EntityAssert<E> isIdLessThanOrEqualTo(long value) {
        long id = getId();
        assertThat(id).isLessThanOrEqualTo(value);
        return instance;
    }

    public EntityAssert<E> isIdEqualTo(long value) {
        long id = getId();
        assertThat(id).isEqualTo(value);
        return instance;
    }

    public EntityAssert<E> isIdNotEqualTo(long value) {
        long id = getId();
        assertThat(id).isNotEqualTo(value);
        return instance;
    }

    public EntityAssert<E> isIdSameAs(long value) {
        long id = getId();
        assertThat(id).isSameAs(value);
        return instance;
    }

    public EntityAssert<E> isIdNotSameAs(long value) {
        long id = getId();
        assertThat(id).isNotSameAs(value);
        return instance;
    }

    private long getId() {
        return getIdFromAccessor().orElseThrow(() -> new AssertionError("Unable to find id of " + value.getClass()));
    }

    private Optional<Long> getIdFromAccessor() {
        return getAccessorsAnnotatedWith(Id.class)
                .map(this::invoke)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findAny();
    }

    private Stream<AccessibleObject> getAccessorsAnnotatedWith(Class<? extends Annotation> annotation) {
        Stream<AccessibleObject> fields = Stream.of(value.getClass().getDeclaredFields());
        Stream<AccessibleObject> methods = getMethods(value.getClass());

        return Stream.concat(fields, methods).filter(o -> o.isAnnotationPresent(annotation));
    }

    private Stream<AccessibleObject> getMethods(Class<?> targetClass) {
        Stream<AccessibleObject> stream = Stream.of(targetClass.getMethods());
        if (targetClass.getSuperclass() != null) {
            Stream<AccessibleObject> parentMethods = getMethods(targetClass.getSuperclass());
            return Stream.concat(stream, parentMethods);
        }
        return stream;
    }

    private <O extends AccessibleObject> Optional<Long> invoke(O object) {
        try {
            object.setAccessible(true);
            if (object instanceof Field) {
                return Optional.of(((Field) object).getLong(value));
            } else if (object instanceof Method) {
                return Optional.ofNullable((Long) ((Method) object).invoke(value));
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public EntityAssert<E> isValid() {
        List<String> invalidAttributes = getInvalidAttributes();
        if (invalidAttributes.isEmpty()) {
            return instance;
        }
        throw error("Expected entity to be valid but has invalid attributes: %s", invalidAttributes);
    }

    public EntityAssert<E> isInvalid() {
        List<String> invalidAttributes = getInvalidAttributes();
        if (!invalidAttributes.isEmpty()) {
            return instance;
        }
        throw error("Expected entity to be invalid");
    }

    public EntityAssert<E> hasInvalidAttributes() {
        return isInvalid();
    }

    public EntityAssert<E> hasInvalidAttribute(String attribute) {
        if (getInvalidAttributes().stream().anyMatch(a -> a.equalsIgnoreCase(attribute))) {
            return instance;
        }
        throw error("Expected entity to have invalid attribute %s", attribute);
    }

    private List<String> getInvalidAttributes() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(value).stream()
                .map(ConstraintViolation::getPropertyPath)
                .map(Path::toString)
                .distinct()
                .sorted()
                .collect(toList());
    }

    public EntityAssert<E> hasNullableFields() {
        //FIXME create new instance
        //FIXME validate
        //FIXME get distinct list of invalid attributes
        //FIXME subtract primitives
        //FIXME compare size of invalid attributes to total count of fields
        return instance;
    }


    public EntityAssert<E> hasTransientFields() {
        if (getAccessorsAnnotatedWith(Transient.class).count() > 0) {
            return instance;
        }
        throw error("Expected entity to have at least one transient field");
    }

//    isComparable()
    //isToStringImplemented()
    //isHashCodeImplemented()
    //isEqualsImplemented()

    public <V> EntityAssert<E> isFieldAccessUnmodified(V attributeValue, BiConsumer<E, V> setter, Function<E, V> getter) {
        setter.accept(value, attributeValue);
        V actualValue = getter.apply(value);
        assertThat(actualValue).isSameAs(attributeValue);
        return instance;
    }

}
