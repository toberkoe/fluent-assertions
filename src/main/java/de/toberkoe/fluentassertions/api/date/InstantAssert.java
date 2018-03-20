package de.toberkoe.fluentassertions.api.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class InstantAssert extends TemporalAssert<InstantAssert, Instant> {

    public InstantAssert(Instant value) {
        super(value);
    }

    @Override
    protected boolean isValueBefore(Instant otherValue) {
        return value.isBefore(otherValue);
    }

    @Override
    protected boolean isValueAfter(Instant otherValue) {
        return value.isAfter(otherValue);
    }

    @Override
    protected boolean isValueInPast() {
        return value.isBefore(Instant.now());
    }

    @Override
    protected boolean isValueInFuture() {
        return value.isAfter(Instant.now());
    }

    @Override
    protected boolean isValueToday() {
        return LocalDate.ofInstant(value, ZoneId.systemDefault()).equals(LocalDate.now());
    }

    @Override
    protected boolean isValueYesterday() {
        return LocalDate.ofInstant(value, ZoneId.systemDefault()).equals(LocalDate.now().minusDays(1));
    }

    @Override
    protected boolean isValueTomorrow() {
        return LocalDate.ofInstant(value, ZoneId.systemDefault()).equals(LocalDate.now().plusDays(1));
    }
}
