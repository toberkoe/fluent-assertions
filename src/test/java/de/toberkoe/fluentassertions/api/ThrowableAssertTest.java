package de.toberkoe.fluentassertions.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ThrowableAssertTest {

    private Throwable withCause;

    @BeforeEach
    void init() {
        withCause = new NullPointerException("NPE");
        for (int i = 0; i < 10; i++) {
            withCause = new IllegalArgumentException(withCause);
        }
    }

    @Test
    void testIsNull() {
        Throwable e = null;
        assertThat(e).isNull();
        assertThrows(AssertionError.class, () -> assertThat(new NullPointerException()).isNull());
    }

    @Test
    void testIsCauseNull() {
        Throwable e = new NullPointerException();
        Throwable e2 = new IllegalArgumentException(new NullPointerException());
        assertThat(e).isCauseNull();
        assertThrows(AssertionError.class, () -> assertThat(e2).isCauseNull());
    }

    @Test
    void testIsCauseNotNull() {
        Throwable e = new NullPointerException();
        Throwable e2 = new IllegalArgumentException(new NullPointerException());
        assertThat(e2).isCauseNotNull();
        assertThrows(AssertionError.class, () -> assertThat(e).isCauseNotNull());
    }

    @Test
    void testHasMessage() {
        Throwable e = new NullPointerException("NPE");
        Throwable e2 = new NullPointerException();
        assertThat(e).isMessageEqualTo("NPE");
        assertThrows(AssertionError.class, () -> assertThat(e2).isMessageEqualTo("NPE"));
    }

    @Test
    void testDoesNotHaveMessage() {
        Throwable e = new NullPointerException("NPE");
        assertThat(e).isMessageNotEqualTo("x");
        assertThrows(AssertionError.class, () -> assertThat(e).isMessageNotEqualTo("NPE"));
    }

    @Test
    void testContainsMessage() {
        Throwable e = new NullPointerException("NPE");
        assertThat(e).containsMessage("P");
        assertThrows(AssertionError.class, () -> assertThat(e).containsMessage("x"));
    }

    @Test
    void testDoesNotContainsMessage() {
        Throwable e = new NullPointerException("NPE");
        assertThat(e).doesNotContainMessage("x");
        assertThrows(AssertionError.class, () -> assertThat(e).doesNotContainMessage("NPE"));
    }

    @Test
    void testIsCauseMessageEqualTo() {
        assertThat(withCause).isCauseMessageEqualTo("NPE");
        assertThrows(AssertionError.class, () -> assertThat(new IllegalArgumentException()).isCauseMessageEqualTo("NPE"));
    }

    @Test
    void testIsCauseMessageNotEqualTo() {
        assertThat(withCause).isCauseMessageNotEqualTo("x");
    }

    @Test
    void testContainsCauseMessage() {
        assertThat(withCause).containsCauseMessage("P");
        assertThrows(AssertionError.class, () -> assertThat(new IllegalArgumentException()).containsCauseMessage("NPE"));
    }

    @Test
    void testDoesNotContainCauseMessage() {
        assertThat(withCause).doesNotContainCauseMessage("x");
    }

    @Test
    void testIsCauseInstanceOf() {
        assertThat(withCause).isCauseInstanceOf(NullPointerException.class);
    }

    @Test
    void testIsCauseNotInstanceOf() {
        assertThat(withCause).isCauseNotInstanceOf(IllegalStateException.class);
    }

    @Test
    void testHasCause() {
        assertThat(withCause).hasCause(NullPointerException.class);
    }

    @Test
    void doesNotHaveCause() {
        assertThat(withCause).doesNotHaveCause(IllegalStateException.class);
    }

}