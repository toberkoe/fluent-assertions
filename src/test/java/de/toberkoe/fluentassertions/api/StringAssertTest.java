package de.toberkoe.fluentassertions.api;

import de.toberkoe.fluentassertions.api.assertions.Assertions;
import org.junit.jupiter.api.Test;

class StringAssertTest {

    @Test
    void testIsNotNull() {
        Assertions.assertThat("").isNotNull();
    }

    @Test
    void testIsNull() {
        String s = null;
        Assertions.assertThat(s).isNull();
    }

    @Test
    void testIsEmpty() {
        String s = "";
        Assertions.assertThat(s).isEmpty();
    }

    @Test
    void testIsNullOrEmpty() {
        String s = "";
        Assertions.assertThat(s).isNullOrEmpty();
    }

    @Test
    void testIsNotEmpty() {
        String s = "text";
        Assertions.assertThat(s).isNotEmpty();
    }

    @Test
    void testIsEqualTo() {
        String s = "text";
        Assertions.assertThat(s).isEqualTo("text");
    }

    @Test
    void testIsNotEqualTo() {
        String s = "text";
        Assertions.assertThat(s).isNotEqualTo("diff");
    }

    @Test
    void testIsEqualToIgnoringCase() {
        String s = "Text";
        Assertions.assertThat(s).isEqualToIgnoringCase("text");
    }

    @Test
    void testContains() {
        String s = "Text";
        Assertions.assertThat(s).contains("ex");
    }

    @Test
    void testDoesNotContain() {
        String s = "Text";
        Assertions.assertThat(s).doesNotContain("abc");
    }

    @Test
    void testStartsWith() {
        String s = "Text";
        Assertions.assertThat(s).startsWith("Te");
    }

    @Test
    void testEndsWith() {
        String s = "Text";
        Assertions.assertThat(s).endsWith("xt");
    }

    @Test
    void testMatches() {
        String s = "Text";
        Assertions.assertThat(s).matches(".*");
    }

    @Test
    void testDoesNotMatch() {
        String s = "Text";
        Assertions.assertThat(s).doesNotMatch("[0-9]+");
    }

    @Test
    void testHasSizeOf() {
        String s = "Text";
        Assertions.assertThat(s).hasSizeOf(4);
    }

    @Test
    void testHasSameSizeAs() {
        String s = "Text";
        Assertions.assertThat(s).hasSameSizeAs(s);
    }


}