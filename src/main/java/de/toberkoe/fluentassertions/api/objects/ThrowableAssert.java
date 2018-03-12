package de.toberkoe.fluentassertions.api.objects;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;

public class ThrowableAssert extends AbstractObjectAssert<ThrowableAssert, Throwable> {

    private static final String ERROR_EXPECTED_CAUSE = "Expected %s to have any cause";

    public ThrowableAssert(Throwable value) {
        super(value);
    }

    public ThrowableAssert isCauseNull() {
        return assertThat(value.getCause()).isNull();
    }

    public ThrowableAssert isCauseNotNull() {
        return assertThat(value.getCause()).isNotNull();
    }

    public ThrowableAssert isMessageEqualTo(String expectedMessage) {
        assertThat(value.getMessage()).isEqualTo(expectedMessage);
        return this;
    }

    public ThrowableAssert isMessageNotEqualTo(String expectedMessage) {
        assertThat(value.getMessage()).isNotEqualTo(expectedMessage);
        return this;
    }

    public ThrowableAssert containsMessage(String expectedMessage) {
        assertThat(value.getMessage()).contains(expectedMessage);
        return this;
    }

    public ThrowableAssert doesNotContainMessage(String expectedMessage) {
        assertThat(value.getMessage()).doesNotContain(expectedMessage);
        return this;
    }

    public ThrowableAssert isCauseMessageEqualTo(String expectedMessage) {
        if (value.getCause() == null) {
            throw error(ERROR_EXPECTED_CAUSE, value);
        }

        try {
            assertThat(value.getCause()).isMessageEqualTo(expectedMessage);
        } catch (AssertionError e) {
            assertThat(value.getCause()).isCauseMessageEqualTo(expectedMessage);
        }
        return this;
    }

    public ThrowableAssert isCauseMessageNotEqualTo(String expectedMessage) {
        if (value.getCause() == null) {
            throw error(ERROR_EXPECTED_CAUSE, value);
        }

        try {
            assertThat(value.getCause()).isMessageNotEqualTo(expectedMessage);
        } catch (AssertionError e) {
            assertThat(value.getCause()).isCauseMessageNotEqualTo(expectedMessage);
        }
        return this;
    }

    public ThrowableAssert containsCauseMessage(String expectedMessage) {
        if (value.getCause() == null) {
            throw error(ERROR_EXPECTED_CAUSE, value);
        }

        try {
            assertThat(value.getCause()).containsMessage(expectedMessage);
        } catch (AssertionError e) {
            assertThat(value.getCause()).containsCauseMessage(expectedMessage);
        }
        return this;
    }

    public ThrowableAssert doesNotContainCauseMessage(String expectedMessage) {
        if (value.getCause() == null) {
            throw error(ERROR_EXPECTED_CAUSE, value);
        }

        try {
            assertThat(value.getCause()).doesNotContainMessage(expectedMessage);
        } catch (AssertionError e) {
            assertThat(value.getCause()).doesNotContainCauseMessage(expectedMessage);
        }
        return this;
    }

    public ThrowableAssert isCauseInstanceOf(Class<?> expectedCauseClass) {
        if (extractThrowable(value, expectedCauseClass) != null) {
            return this;
        }
        throw error("Expected %s to have cause typed %s", value.getClass().getName(), expectedCauseClass);
    }

    public ThrowableAssert isCauseNotInstanceOf(Class<?> expectedCauseClass) {
        if (extractThrowable(value, expectedCauseClass) == null) {
            return this;
        }
        throw error("Expected %s to have no cause typed %s", value.getClass().getName(), expectedCauseClass);
    }

    public ThrowableAssert hasCause(Class<?> expectedCauseClass) {
        return isCauseInstanceOf(expectedCauseClass);
    }

    public ThrowableAssert doesNotHaveCause(Class<?> expectedCauseClass) {
        return isCauseNotInstanceOf(expectedCauseClass);
    }

    /**
     * Extracts the requested throwable from given {@link Throwable}.
     *
     * @param exception  the complete exception stack
     * @param causeClass the requested cause to search for
     * @return found throwable or null
     */
    private Throwable extractThrowable(Throwable exception, Class<?> causeClass) {
        if (exception == null) {
            return null;
        } else if (causeClass.isInstance(exception)) {
            return exception;
        } else {
            return extractThrowable(exception.getCause(), causeClass);
        }
    }

}
