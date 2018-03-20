package de.toberkoe.fluentassertions.api.date;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateTimeAssert extends TemporalAssert<LocalDateTimeAssert, LocalDateTime> {

    public LocalDateTimeAssert(LocalDateTime value) {
        super(value);
    }

    @Override
    protected boolean isValueBefore(LocalDateTime otherValue) {
        return value.isBefore(otherValue);
    }

    @Override
    protected boolean isValueAfter(LocalDateTime otherValue) {
        return value.isAfter(otherValue);
    }

    @Override
    protected boolean isValueInPast() {
        return value.isBefore(LocalDateTime.now());
    }

    @Override
    protected boolean isValueInFuture() {
        return value.isAfter(LocalDateTime.now());
    }

    @Override
    protected boolean isValueToday() {
        return value.toLocalDate().equals(LocalDate.now());
    }

    @Override
    protected boolean isValueYesterday() {
        return value.toLocalDate().equals(LocalDate.now().minusDays(1));
    }

    @Override
    protected boolean isValueTomorrow() {
        return value.toLocalDate().equals(LocalDate.now().plusDays(1));
    }
}
