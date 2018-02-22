package de.toberkoe.fluentassertions.api;

import de.toberkoe.fluentassertions.api.assertions.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StringAssertTest {

    @Test
    void testIsNotNull() {
        Assertions.assertThat("").isNotNull();
    }

    @Test
    void testIsNull() {
        String s = null;
        Assertions.assertThat(s).isNull();
        assertThrows(AssertionError.class, () -> Assertions.assertThat("").isNull());
    }

    @Test
    void testIsEmpty() {
        String s = "";
        Assertions.assertThat(s).isEmpty();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(" ").isEmpty());
    }

    @Test
    void testIsNullOrEmpty() {
        String s = "";
        Assertions.assertThat(s).isNullOrEmpty();
        assertThrows(AssertionError.class, () -> Assertions.assertThat(" ").isNullOrEmpty());
    }

    @Test
    void testIsNotEmpty() {
        String s = "text";
        Assertions.assertThat(s).isNotEmpty();
        assertThrows(AssertionError.class, () -> Assertions.assertThat("").isNotEmpty());
    }

    @Test
    void testIsEqualTo() {
        String s = "text";
        Assertions.assertThat(s).isEqualTo("text");
        assertThrows(AssertionError.class, () -> Assertions.assertThat("text").isEqualTo("Test"));
    }

    @Test
    void testIsNotEqualTo() {
        String s = "text";
        Assertions.assertThat(s).isNotEqualTo("diff");
        assertThrows(AssertionError.class, () -> Assertions.assertThat(s).isNotEqualTo(s));
    }

    @Test
    void testIsEqualToIgnoringCase() {
        String s = "Text";
        Assertions.assertThat(s).isEqualToIgnoringCase("text");
        assertThrows(AssertionError.class, () -> Assertions.assertThat(s).isEqualToIgnoringCase("x"));
    }

    @Test
    void testContains() {
        String s = "Text";
        Assertions.assertThat(s).contains("ex");
        assertThrows(AssertionError.class, () -> Assertions.assertThat(s).contains("a"));
    }

    @Test
    void testDoesNotContain() {
        String s = "Text";
        Assertions.assertThat(s).doesNotContain("abc");
        assertThrows(AssertionError.class, () -> Assertions.assertThat(s).doesNotContain("x"));
    }

    @Test
    void testStartsWith() {
        String s = "Text";
        Assertions.assertThat(s).startsWith("Te");
        assertThrows(AssertionError.class, () -> Assertions.assertThat(s).startsWith("e"));
    }

    @Test
    void testEndsWith() {
        String s = "Text";
        Assertions.assertThat(s).endsWith("xt");
        assertThrows(AssertionError.class, () -> Assertions.assertThat(s).endsWith("e"));
    }

    @Test
    void testMatches() {
        String s = "Text";
        Assertions.assertThat(s).matches(".*");
        assertThrows(AssertionError.class, () -> Assertions.assertThat(s).matches("[0-9]+"));
    }

    @Test
    void testDoesNotMatch() {
        String s = "Text";
        Assertions.assertThat(s).doesNotMatch("[0-9]+");
        assertThrows(AssertionError.class, () -> Assertions.assertThat(s).doesNotMatch(".*"));
    }

    @Test
    void testHasSizeOf() {
        String s = "Text";
        Assertions.assertThat(s).hasSizeOf(4);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(s).hasSizeOf(1));
    }

    @Test
    void testHasSameSizeAs() {
        String s = "Text";
        Assertions.assertThat(s).hasSameSizeAs(s);
        assertThrows(AssertionError.class, () -> Assertions.assertThat(s).hasSameSizeAs("abc"));
    }


}