package de.toberkoe.fluentassertions.api.date;

import java.time.LocalDate;

public class LocalDateAssert extends TemporalAssert<LocalDateAssert, LocalDate> {

    public LocalDateAssert(LocalDate value) {
        super(value);
    }

    @Override
    protected boolean isValueBefore(LocalDate otherValue) {
        return value.isBefore(otherValue);
    }

    @Override
    protected boolean isValueAfter(LocalDate otherValue) {
        return value.isAfter(otherValue);
    }

    @Override
    protected boolean isValueInPast() {
        return value.isBefore(LocalDate.now());
    }

    @Override
    protected boolean isValueInFuture() {
        return value.isAfter(LocalDate.now());
    }

    @Override
    protected boolean isValueToday() {
        return value.equals(LocalDate.now());
    }

    @Override
    protected boolean isValueYesterday() {
        return value.equals(LocalDate.now().minusDays(1));
    }

    @Override
    protected boolean isValueTomorrow() {
        return value.equals(LocalDate.now().plusDays(1));
    }

}
