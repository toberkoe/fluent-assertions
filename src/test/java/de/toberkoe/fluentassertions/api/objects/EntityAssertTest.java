package de.toberkoe.fluentassertions.api.objects;

import de.toberkoe.fluentassertions.api.objects.entities.DummyEntity;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static de.toberkoe.fluentassertions.api.Assertions.assertThatEntity;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EntityAssertTest {

    @Test
    void isIdZero() {
        assertThatEntity(DummyEntity.ZERO).isIdZero();
        assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.POSITIVE).isIdZero());
    }

    @Test
    void isIdNotZero() {
        assertThatEntity(DummyEntity.POSITIVE).isIdNotZero();
        assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdNotZero());
    }

    @Test
    void isIdPositive() {
        assertThatEntity(DummyEntity.POSITIVE).isIdPositive();
        assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdPositive());
    }

    @Test
    void isIdNegative() {
        assertThatEntity(DummyEntity.NEGATIVE).isIdNegative();
        assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdNegative());
    }

    @Test
    void isIdGreaterThan() {
        assertThatEntity(DummyEntity.POSITIVE).isIdGreaterThan(0);
        assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdGreaterThan(0));
    }

    @Test
    void isIdGreaterThanOrEqualTo() {
        assertThatEntity(DummyEntity.POSITIVE).isIdGreaterThanOrEqualTo(0);
        assertThatEntity(DummyEntity.POSITIVE).isIdGreaterThanOrEqualTo(1);
        assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.NEGATIVE).isIdGreaterThanOrEqualTo(0));
    }

    @Test
    void isIdLessThan() {
        assertThatEntity(DummyEntity.NEGATIVE).isIdLessThan(0);
        assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdLessThan(0));
    }

    @Test
    void isIdLessThanOrEqualTo() {
        assertThatEntity(DummyEntity.NEGATIVE).isIdLessThanOrEqualTo(-1);
        assertThatEntity(DummyEntity.NEGATIVE).isIdLessThanOrEqualTo(0);
        assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.POSITIVE).isIdLessThanOrEqualTo(0));
    }

    @Test
    void isIdEqualTo() {
        assertThatEntity(DummyEntity.ZERO).isIdEqualTo(0);
        assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdEqualTo(1));
    }

    @Test
    void isIdNotEqualTo() {
        assertThatEntity(DummyEntity.ZERO).isIdNotEqualTo(1);
        assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdNotEqualTo(0));
    }

    @Test
    void isIdSameAs() {
        assertThatEntity(DummyEntity.ZERO).isIdSameAs(0);
        assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdSameAs(1));
    }

    @Test
    void isIdNotSameAs() {
        assertThatEntity(DummyEntity.ZERO).isIdNotSameAs(1);
        assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdNotSameAs(0));
    }

    @Test
    void isFieldAccessUnmodified() {
        DummyEntity entity = new DummyEntity();
        String name = "Duke";
        BiConsumer<DummyEntity, String> setter = DummyEntity::setName;

        assertThatEntity(entity).isFieldAccessUnmodified(name, setter, DummyEntity::getName);
        assertThrows(AssertionError.class, () -> assertThatEntity(entity).isFieldAccessUnmodified(null, setter, DummyEntity::getNameModified));
    }

    @Test
    void isValid() {
        DummyEntity validEntity = new DummyEntity(1L, "Duke");
        DummyEntity invalidEntity = new DummyEntity(0L, null);
        assertThatEntity(validEntity).isValid();
        assertThrows(AssertionError.class, () -> assertThatEntity(invalidEntity).isValid());
    }

    @Test
    void isInvalid() {
        DummyEntity validEntity = new DummyEntity(1L, "Duke");
        DummyEntity invalidEntity = new DummyEntity(0L, null);
        assertThatEntity(invalidEntity).isInvalid();
        assertThrows(AssertionError.class, () -> assertThatEntity(validEntity).isInvalid());
    }

    @Test
    void hasInvalidAttributes() {
        DummyEntity validEntity = new DummyEntity(1L, "Duke");
        DummyEntity invalidEntity = new DummyEntity(0L, null);
        assertThatEntity(invalidEntity).hasInvalidAttributes();
        assertThrows(AssertionError.class, () -> assertThatEntity(validEntity).hasInvalidAttributes());
    }

    @Test
    void hasInvalidAttribute() {
        DummyEntity validEntity = new DummyEntity(1L, "Duke");
        DummyEntity invalidEntity = new DummyEntity(0L, null);
        assertThatEntity(invalidEntity).hasInvalidAttribute("name");
        assertThatEntity(invalidEntity).hasInvalidAttribute("id");
        assertThrows(AssertionError.class, () -> assertThatEntity(validEntity).hasInvalidAttribute("name"));
    }

//    hasNullableFields()
//    hasTransientFields()
//    isComparable()
    //isToStringImplemented()
    //isHashCodeImplemented()
    //isEqualsImplemented()

    @Test
    void isNull() {
    }

    @Test
    void isNotNull() {
    }

    @Test
    void isEqualTo() {
    }

    @Test
    void isNotEqualTo() {
    }

    @Test
    void isSameAs() {
    }

    @Test
    void isNotSameAs() {
    }

    @Test
    void isInstanceOf() {
    }

    @Test
    void isNotInstanceOf() {
    }

    @Test
    void isInstanceOfAny() {
    }

    @Test
    void isNotInstanceOfAny() {
    }
}