package de.toberkoe.fluentassertions.api.objects;

import de.toberkoe.fluentassertions.api.objects.entities.DummyEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static de.toberkoe.fluentassertions.api.Assertions.assertThatEntity;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Entity Assertions")
class EntityAssertTest {

    @Nested
    @DisplayName("Id")
    class IdTests {

        @Nested
        @DisplayName("zero")
        class ZeroId {
            @Test
            @DisplayName("id is zero")
            void isIdZero() {
                assertThatEntity(DummyEntity.ZERO).isIdZero();
                assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.POSITIVE).isIdZero());
            }

            @Test
            @DisplayName("id is not zero")
            void isIdNotZero() {
                assertThatEntity(DummyEntity.POSITIVE).isIdNotZero();
                assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdNotZero());
            }
        }

        @Nested
        @DisplayName("greater than")
        class GreaterThan {
            @Test
            @DisplayName("is positive")
            void isIdPositive() {
                assertThatEntity(DummyEntity.POSITIVE).isIdPositive();
                assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdPositive());
            }

            @Test
            @DisplayName("is greater than")
            void isIdGreaterThan() {
                assertThatEntity(DummyEntity.POSITIVE).isIdGreaterThan(0);
                assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdGreaterThan(0));
            }

            @Test
            @DisplayName("is greater than or equal to")
            void isIdGreaterThanOrEqualTo() {
                assertThatEntity(DummyEntity.POSITIVE).isIdGreaterThanOrEqualTo(0);
                assertThatEntity(DummyEntity.POSITIVE).isIdGreaterThanOrEqualTo(1);
                assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.NEGATIVE).isIdGreaterThanOrEqualTo(0));
            }
        }

        @Nested
        @DisplayName("less than")
        class LessThan {
            @Test
            @DisplayName("is negative")
            void isIdNegative() {
                assertThatEntity(DummyEntity.NEGATIVE).isIdNegative();
                assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdNegative());
            }

            @Test
            @DisplayName("is less than")
            void isIdLessThan() {
                assertThatEntity(DummyEntity.NEGATIVE).isIdLessThan(0);
                assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdLessThan(0));
            }

            @Test
            @DisplayName("is less than or equal to")
            void isIdLessThanOrEqualTo() {
                assertThatEntity(DummyEntity.NEGATIVE).isIdLessThanOrEqualTo(-1);
                assertThatEntity(DummyEntity.NEGATIVE).isIdLessThanOrEqualTo(0);
                assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.POSITIVE).isIdLessThanOrEqualTo(0));
            }
        }

        @Nested
        @DisplayName("equality")
        class Equality {
            @Test
            @DisplayName("equal to")
            void isIdEqualTo() {
                assertThatEntity(DummyEntity.ZERO).isIdEqualTo(0);
                assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdEqualTo(1));
            }

            @Test
            @DisplayName("not equal to")
            void isIdNotEqualTo() {
                assertThatEntity(DummyEntity.ZERO).isIdNotEqualTo(1);
                assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdNotEqualTo(0));
            }

            @Test
            @DisplayName("same as")
            void isIdSameAs() {
                assertThatEntity(DummyEntity.ZERO).isIdSameAs(0);
                assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdSameAs(1));
            }

            @Test
            @DisplayName("not same as")
            void isIdNotSameAs() {
                assertThatEntity(DummyEntity.ZERO).isIdNotSameAs(1);
                assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isIdNotSameAs(0));
            }
        }
    }

    @Nested
    @DisplayName("Validation")
    class Validation {
        @Test
        @DisplayName("is valid")
        void isValid() {
            DummyEntity validEntity = new DummyEntity(1L, "Duke");
            DummyEntity invalidEntity = new DummyEntity(0L, null);
            assertThatEntity(validEntity).isValid();
            assertThrows(AssertionError.class, () -> assertThatEntity(invalidEntity).isValid());
        }

        @Test
        @DisplayName("is invalid")
        void isInvalid() {
            DummyEntity validEntity = new DummyEntity(1L, "Duke");
            DummyEntity invalidEntity = new DummyEntity(0L, null);
            assertThatEntity(invalidEntity).isInvalid();
            assertThrows(AssertionError.class, () -> assertThatEntity(validEntity).isInvalid());
        }

        @Test
        @DisplayName("has invalid attributes")
        void hasInvalidAttributes() {
            DummyEntity validEntity = new DummyEntity(1L, "Duke");
            DummyEntity invalidEntity = new DummyEntity(0L, null);
            assertThatEntity(invalidEntity).hasInvalidAttributes();
            assertThrows(AssertionError.class, () -> assertThatEntity(validEntity).hasInvalidAttributes());
        }

        @Test
        @DisplayName("has invalid attribute")
        void hasInvalidAttribute() {
            DummyEntity validEntity = new DummyEntity(1L, "Duke");
            DummyEntity invalidEntity = new DummyEntity(0L, null);
            assertThatEntity(invalidEntity).hasInvalidAttribute("name");
            assertThatEntity(invalidEntity).hasInvalidAttribute("id");
            assertThrows(AssertionError.class, () -> assertThatEntity(validEntity).hasInvalidAttribute("name"));
        }
    }

    @Nested
    @DisplayName("Structure")
    class Structure {
        @Test
        @DisplayName("plain getter and setter")
        void isFieldAccessUnmodified() {
            DummyEntity entity = new DummyEntity();
            String name = "Duke";
            BiConsumer<DummyEntity, String> setter = DummyEntity::setName;

            assertThatEntity(entity).isFieldAccessUnmodified(name, setter, DummyEntity::getName);
            assertThrows(AssertionError.class, () -> assertThatEntity(entity).isFieldAccessUnmodified(null, setter, DummyEntity::getNameModified));
        }

        @Test
        @DisplayName("has transient fields")
        void hasTransientFields() {
            DummyEntity validEntity = new DummyEntity(1L, "Duke");
            assertThatEntity(validEntity).hasTransientFields();
            assertThrows(AssertionError.class, () -> assertThatEntity("").hasTransientFields());
        }

        @Test
        @DisplayName("is comparable")
        void isComparable() {
            assertThatEntity("").isComparable();
            assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isComparable());
        }

        @Test
        @DisplayName("has toString()")
        void isToStringImplemented() {
            assertThatEntity("").isToStringImplemented();
            assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isToStringImplemented());
        }

        @Test
        @DisplayName("has hashCode()")
        void isHashCodeImplemented() {
            assertThatEntity("").isHashCodeImplemented();
            assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isHashCodeImplemented());
        }

        @Test
        @DisplayName("has equals()")
        void isEqualsImplemented() {
            assertThatEntity("").isEqualsImplemented();
            assertThrows(AssertionError.class, () -> assertThatEntity(DummyEntity.ZERO).isEqualsImplemented());
        }
    }

    @Nested
    @DisplayName("Null")
    class Null {
        @Test
        @DisplayName("is null")
        void isNull() {
            assertThatEntity(null).isNull();
            assertThrows(AssertionError.class, () -> assertThatEntity("").isNull());
        }

        @Test
        @DisplayName("is not null")
        void isNotNull() {
            assertThatEntity("").isNotNull();
            assertThrows(AssertionError.class, () -> assertThatEntity(null).isNotNull());
        }
    }

    @Nested
    @DisplayName("Equality")
    class Equality {
        @Test
        @DisplayName("is equal to")
        void isEqualTo() {
            assertThatEntity("").isEqualTo("");
            assertThrows(AssertionError.class, () -> assertThatEntity("").isEqualTo(" "));
        }

        @Test
        @DisplayName("is not equal to")
        void isNotEqualTo() {
            assertThatEntity("").isNotEqualTo(" ");
            assertThrows(AssertionError.class, () -> assertThatEntity("").isNotEqualTo(""));
        }

        @Test
        @DisplayName("is same as")
        void isSameAs() {
            assertThatEntity("").isSameAs("");
            assertThrows(AssertionError.class, () -> assertThatEntity("").isSameAs(" "));
        }

        @Test
        @DisplayName("is not same as")
        void isNotSameAs() {
            assertThatEntity("").isNotSameAs(" ");
            assertThrows(AssertionError.class, () -> assertThatEntity("").isNotSameAs(""));
        }
    }

    @Nested
    @DisplayName("InstanceOf")
    class InstanceOf {
        @Test
        @DisplayName("is instance of")
        void isInstanceOf() {
            assertThatEntity("").isInstanceOf(String.class);
            assertThrows(AssertionError.class, () -> assertThatEntity("").isInstanceOf(Integer.class));
        }

        @Test
        @DisplayName("is not instance of")
        void isNotInstanceOf() {
            assertThatEntity("").isNotInstanceOf(Integer.class);
            assertThrows(AssertionError.class, () -> assertThatEntity("").isNotInstanceOf(String.class));
        }

        @Test
        @DisplayName("is instance of any")
        void isInstanceOfAny() {
            assertThatEntity("").isInstanceOfAny(String.class);
            assertThrows(AssertionError.class, () -> assertThatEntity("").isInstanceOfAny(Integer.class));
        }

        @Test
        @DisplayName("is not instance of any")
        void isNotInstanceOfAny() {
            assertThatEntity("").isNotInstanceOfAny(Integer.class);
            assertThrows(AssertionError.class, () -> assertThatEntity("").isNotInstanceOfAny(String.class));
        }
    }
}