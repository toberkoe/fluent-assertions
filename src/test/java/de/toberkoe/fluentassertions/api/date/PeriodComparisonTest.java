package de.toberkoe.fluentassertions.api.date;

import org.junit.jupiter.api.Test;

import java.time.Period;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;

class PeriodComparisonTest {

    private Period lower = Period.of(1, 3, 25);
    private Period middle = Period.ofYears(2);
    private Period greater = Period.of(3, 6, 9);

    @Test
    void isLowerThan() {
        PeriodComparison comparison = new PeriodComparison(lower);
        assertThat(comparison.isLowerThan(middle)).isTrue();
    }

    @Test
    void isGreaterThan() {
        PeriodComparison comparison = new PeriodComparison(greater);
        assertThat(comparison.isGreaterThan(middle)).isTrue();
    }

    @Test
    void isEqualTo() {
        PeriodComparison comparison = new PeriodComparison(middle);
        assertThat(comparison.isEqualTo(middle)).isTrue();
    }
}