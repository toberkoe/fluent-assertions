package de.toberkoe.fluentassertions.api.assertions;

/**
 * Factory class for type-specific assertions.
 *
 * @author t.bertram-koehler
 */
public class Assertions {

    /**
     * Creates an instance of {link StringAssert}.
     *
     * @param string the value to be asserted
     * @return instance of assertion object
     */
    public static StringAssert assertThat(String string) {
        return new StringAssert(string);
    }
}
