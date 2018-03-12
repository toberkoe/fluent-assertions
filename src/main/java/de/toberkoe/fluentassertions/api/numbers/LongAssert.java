package de.toberkoe.fluentassertions.api.numbers;

import de.toberkoe.fluentassertions.api.Assertions;

/**
 * {@code Long} Assertions.
 * Create a new instance by using {@link Assertions#assertThat(Long)}.
 *
 * @author t.bertram-koehler
 */
public class LongAssert extends NumberAssert<LongAssert, Long> {

    public LongAssert(Long value) {
        super(value);
    }

}