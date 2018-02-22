package de.toberkoe.fluentassertions.api.assertions;

/**
 * {@code Long} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Long)}.
 *
 * @author t.bertram-koehler
 */
public class LongAssert extends NumberAssert<LongAssert, Long> {

    protected LongAssert(Long value) {
        super(value);
    }

}