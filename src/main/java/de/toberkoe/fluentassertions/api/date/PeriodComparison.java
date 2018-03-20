package de.toberkoe.fluentassertions.api.date;

import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

class PeriodComparison {

    private static final Function<Period, Integer> periodToDays = p -> (p.getYears() * 12 + p.getMonths()) * 30 + p.getDays();

    private final int daysOfPeriod;

    PeriodComparison(Period period) {
        daysOfPeriod = periodToDays.apply(period);
    }

    public PeriodComparison(int count, ChronoUnit unit) {
        Period period = null;
        switch (unit) {
            case DAYS:
                period = Period.ofDays(count);
                break;
            case WEEKS:
                period = Period.ofWeeks(count);
                break;
            case MONTHS:
                period = Period.ofMonths(count);
                break;
            case YEARS:
                period = Period.ofYears(count);
                break;
            default:
                throw new UnsupportedOperationException("Unhandled ChronoUnit " + unit);
        }

        daysOfPeriod = periodToDays.apply(period);
    }

    boolean isLowerThan(Period otherPeriod) {
        int expected = periodToDays.apply(otherPeriod);
        return daysOfPeriod < expected;
    }

    boolean isGreaterThan(Period otherPeriod) {
        int expected = periodToDays.apply(otherPeriod);
        return daysOfPeriod > expected;
    }

    boolean isEqualTo(Period otherPeriod) {
        int expected = periodToDays.apply(otherPeriod);
        return daysOfPeriod == expected;
    }

    public int getDays() {
        return daysOfPeriod;
    }
}
