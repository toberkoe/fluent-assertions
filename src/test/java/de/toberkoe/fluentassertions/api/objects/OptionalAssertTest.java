package de.toberkoe.fluentassertions.api.objects;

import de.toberkoe.fluentassertions.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OptionalAssertTest {

    @Test
    void testIsEmpty() {
        Optional<String> optional = Optional.empty();
        Assertions.assertThat(optional).isEmpty();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(Optional.of("")).isEmpty());
    }

    @Test
    void testIsNotEmpty() {
        Optional<String> optional = Optional.of("");
        Assertions.assertThat(optional).isNotEmpty();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(Optional.empty()).isNotEmpty());
    }

    @Test
    void testIsValueEqualTo() {
        Optional<String> optional = Optional.of("text");
        Assertions.assertThat(optional).isValueEqualTo("text");
        assertThrows(AssertionError.class, () -> Assertions.assertThat(Optional.of(1)).isValueEqualTo(""));
    }

    @Test
    void testIsValueNotEqualTo() {
        Optional<String> optional = Optional.of("text");
        Assertions.assertThat(optional).isValueNotEqualTo("");
        assertThrows(AssertionError.class, () -> Assertions.assertThat(Optional.of("")).isValueNotEqualTo(""));
    }
}