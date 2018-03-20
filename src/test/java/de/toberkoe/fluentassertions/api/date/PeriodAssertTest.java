package de.toberkoe.fluentassertions.api.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PeriodAssertTest {

    private Period week = Period.ofWeeks(1);
    private Period day = Period.ofDays(1);
    private Period year = Period.ofYears(1);

    @Test
    void isZero() {
        assertThat(Period.ZERO).isZero();
        assertThrows(AssertionError.class, () -> assertThat(day).isZero());
    }

    @Test
    void isPositive() {
        assertThat(year).isPositive();
        assertThrows(AssertionError.class, () -> assertThat(Period.ZERO).isPositive());
    }

    @Test
    void isNegative() {
        assertThat(Period.between(LocalDate.now(), LocalDate.now().minusDays(1))).isNegative();
        assertThrows(AssertionError.class, () -> assertThat(Period.ZERO).isNegative());
        assertThrows(AssertionError.class, () -> assertThat(week).isNegative());
    }

    @Test
    void isGreaterThan() {
        assertThat(week).isGreaterThan(day);
        assertThrows(AssertionError.class, () -> assertThat(week).isGreaterThan(week));
        assertThrows(AssertionError.class, () -> assertThat(week).isGreaterThan(year));
    }

    @Test
    void isGreaterThanOrEqualTo() {
        assertThat(week).isGreaterThanOrEqualTo(day);
        assertThat(week).isGreaterThanOrEqualTo(week);
        assertThrows(AssertionError.class, () -> assertThat(week).isGreaterThanOrEqualTo(year));
    }

    @Test
    void isLowerThan() {
        assertThat(day).isLowerThan(week);
        assertThrows(AssertionError.class, () -> assertThat(week).isLowerThan(week));
        assertThrows(AssertionError.class, () -> assertThat(year).isLowerThan(week));
    }

    @Test
    void isLowerThanOrEqualTo() {
        assertThat(day).isLowerThanOrEqualTo(week);
        assertThat(week).isLowerThanOrEqualTo(week);
        assertThrows(AssertionError.class, () -> assertThat(year).isLowerThanOrEqualTo(week));
    }

    @Test
    void hasAtLeastDays() {
        assertThat(week).hasAtLeastDays(1);
        assertThat(week).hasAtLeastDays(7);
        assertThrows(AssertionError.class, () -> assertThat(day).hasAtLeastDays(7));
    }

    @Test
    void hasExactlyDays() {
        assertThat(week).hasExactlyDays(7);
        assertThrows(AssertionError.class, () -> assertThat(week).hasExactlyDays(6));
        assertThrows(AssertionError.class, () -> assertThat(week).hasExactlyDays(8));
    }

    @Test
    void doesNotHaveMoreThanDays() {
        assertThat(week).doesNotHaveMoreThanDays(7);
        assertThat(week).doesNotHaveMoreThanDays(8);
        assertThrows(AssertionError.class, () -> assertThat(week).doesNotHaveMoreThanDays(6));
    }

    @Test
    void hasAtLeastWeeks() {
        assertThat(week).hasAtLeastWeeks(1);
        assertThat(week).hasAtLeastWeeks(0);
        assertThrows(AssertionError.class, () -> assertThat(week).hasAtLeastWeeks(2));
    }

    @Test
    void hasExactlyWeeks() {
        assertThat(week).hasExactlyWeeks(1);
        assertThrows(AssertionError.class, () -> assertThat(week).hasExactlyWeeks(0));
        assertThrows(AssertionError.class, () -> assertThat(week).hasExactlyWeeks(2));
    }

    @Test
    void doesNotHaveMoreThanWeeks() {
        assertThat(week).doesNotHaveMoreThanWeeks(1);
        assertThat(week).doesNotHaveMoreThanWeeks(2);
        assertThrows(AssertionError.class, () -> assertThat(week).doesNotHaveMoreThanWeeks(0));
    }

    @Test
    void hasAtLeastMonths() {
        assertThat(year).hasAtLeastMonths(1);
        assertThat(year).hasAtLeastMonths(12);
        assertThrows(AssertionError.class, () -> assertThat(year).hasAtLeastMonths(13));
    }

    @Test
    void hasExactlyMonths() {
        assertThat(year).hasExactlyMonths(12);
        assertThrows(AssertionError.class, () -> assertThat(year).hasExactlyMonths(11));
        assertThrows(AssertionError.class, () -> assertThat(year).hasExactlyMonths(13));
    }

    @Test
    void doesNotHaveMoreThanMonths() {
        assertThat(year).doesNotHaveMoreThanMonths(12);
        assertThat(year).doesNotHaveMoreThanMonths(13);
        assertThrows(AssertionError.class, () -> assertThat(year).doesNotHaveMoreThanMonths(11));
    }

    @Test
    void hasAtLeastYears() {
        assertThat(year).hasAtLeastYears(1);
        assertThat(year).hasAtLeastYears(0);
        assertThrows(AssertionError.class, () -> assertThat(year).hasAtLeastYears(2));
    }

    @Test
    void hasExactlyYears() {
        assertThat(year).hasExactlyYears(1);
        assertThrows(AssertionError.class, () -> assertThat(year).hasExactlyYears(0));
        assertThrows(AssertionError.class, () -> assertThat(year).hasExactlyYears(2));
    }

    @Test
    void doesNotHaveMoreThanYears() {
        assertThat(year).doesNotHaveMoreThanYears(1);
        assertThat(year).doesNotHaveMoreThanYears(2);
        assertThrows(AssertionError.class, () -> assertThat(year).doesNotHaveMoreThanYears(0));
    }

    @Test
    void isNull() {
        assertThat((Period) null).isNull();
    }

    @Test
    void isNotNull() {
        assertThat(week).isNotNull();
    }

    @Test
    void isEqualTo() {
        assertThat(week).isEqualTo(week);
    }

    @Test
    void isNotEqualTo() {
        assertThat(week).isNotEqualTo(day);
    }

    @Test
    void isSameAs() {
        assertThat(year).isSameAs(year);
    }

    @Test
    void isNotSameAs() {
        assertThat(year).isNotSameAs(day);
    }

    @Test
    void isInstanceOf() {
        assertThat(year).isInstanceOf(Period.class);
    }

    @Test
    void isNotInstanceOf() {
        assertThat(year).isNotInstanceOf(String.class);
    }

    @Test
    void isInstanceOfAny() {
        assertThat(day).isInstanceOfAny(String.class, Period.class);
    }

    @Test
    void isNotInstanceOfAny() {
        assertThat(day).isNotInstanceOfAny(String.class, Integer.class);
    }
}