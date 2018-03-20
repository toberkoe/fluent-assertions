package de.toberkoe.fluentassertions.api.date;

import de.toberkoe.fluentassertions.api.objects.AbstractObjectAssert;

import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodAssert extends AbstractObjectAssert<PeriodAssert, Period> {

    public PeriodAssert(Period value) {
        super(value);
    }

    public PeriodAssert isZero() {
        if (value.isZero()) {
            return instance;
        }
        throw error("Expected period to be zero but was %s", value);
    }

    public PeriodAssert isPositive() {
        if (!value.isNegative() && !value.isZero()) {
            return instance;
        }
        throw error("Expected period to be positive but was %s", value);
    }

    public PeriodAssert isNegative() {
        if (value.isNegative()) {
            return instance;
        }
        throw error("Expected period to be negative but was %s", value);
    }

    public PeriodAssert isGreaterThan(Period period) {
        PeriodComparison comparison = new PeriodComparison(value);
        if (comparison.isGreaterThan(period)) {
            return instance;
        }
        throw error("Expected period to be greater than %s but was %s", period, value);
    }

    public PeriodAssert isGreaterThanOrEqualTo(Period period) {
        PeriodComparison comparison = new PeriodComparison(value);
        if (comparison.isGreaterThan(period) || comparison.isEqualTo(period)) {
            return instance;
        }
        throw error("Expected period to be greater than or equal to %s but was %s", period, value);
    }

    public PeriodAssert isLowerThan(Period period) {
        PeriodComparison comparison = new PeriodComparison(value);
        if (comparison.isLowerThan(period)) {
            return instance;
        }
        throw error("Expected period to be lower than %s but was %s", period, value);
    }

    public PeriodAssert isLowerThanOrEqualTo(Period period) {
        PeriodComparison comparison = new PeriodComparison(value);
        if (comparison.isLowerThan(period) || comparison.isEqualTo(period)) {
            return instance;
        }
        throw error("Expected period to be lower than or equal to %s but was %s", period, value);
    }

    public PeriodAssert hasAtLeastDays(int days) {
        return hasAtLeast(days, ChronoUnit.DAYS);
    }

    public PeriodAssert hasExactlyDays(int days) {
        return hasExactly(days, ChronoUnit.DAYS);
    }

    public PeriodAssert doesNotHaveMoreThanDays(int days) {
        return doesNotHaveMoreThan(days, ChronoUnit.DAYS);
    }

    public PeriodAssert hasAtLeastWeeks(int weeks) {
        return hasAtLeast(weeks, ChronoUnit.WEEKS);
    }

    public PeriodAssert hasExactlyWeeks(int weeks) {
        return hasExactly(weeks, ChronoUnit.WEEKS);
    }

    public PeriodAssert doesNotHaveMoreThanWeeks(int weeks) {
        return doesNotHaveMoreThan(weeks, ChronoUnit.WEEKS);
    }

    public PeriodAssert hasAtLeastMonths(int months) {
        return hasAtLeast(months, ChronoUnit.MONTHS);
    }

    public PeriodAssert hasExactlyMonths(int months) {
        return hasExactly(months, ChronoUnit.MONTHS);
    }

    public PeriodAssert doesNotHaveMoreThanMonths(int months) {
        return doesNotHaveMoreThan(months, ChronoUnit.MONTHS);
    }

    public PeriodAssert hasAtLeastYears(int years) {
        return hasAtLeast(years, ChronoUnit.YEARS);
    }

    public PeriodAssert hasExactlyYears(int years) {
        return hasExactly(years, ChronoUnit.YEARS);
    }

    public PeriodAssert doesNotHaveMoreThanYears(int years) {
        return doesNotHaveMoreThan(years, ChronoUnit.YEARS);
    }

    private PeriodAssert hasAtLeast(int count, ChronoUnit unit) {
        int expectedDays = new PeriodComparison(count, unit).getDays();
        int actualDays = new PeriodComparison(value).getDays();
        if (actualDays >= expectedDays) {
            return instance;
        }
        throw error("Expected to have at least %s days but was %s days", expectedDays, actualDays);
    }

    private PeriodAssert hasExactly(int count, ChronoUnit unit) {
        int expectedDays = new PeriodComparison(count, unit).getDays();
        int actualDays = new PeriodComparison(value).getDays();
        if (actualDays == expectedDays) {
            return instance;
        }
        throw error("Expected to have exactly %s days but was %s days", expectedDays, actualDays);
    }

    private PeriodAssert doesNotHaveMoreThan(int count, ChronoUnit unit) {
        int expectedDays = new PeriodComparison(count, unit).getDays();
        int actualDays = new PeriodComparison(value).getDays();
        if (actualDays <= expectedDays) {
            return instance;
        }
        throw error("Expected to have not more than %s days but was %s days", expectedDays, actualDays);
    }
}
