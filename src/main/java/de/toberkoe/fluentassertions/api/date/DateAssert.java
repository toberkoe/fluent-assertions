package de.toberkoe.fluentassertions.api.date;

import de.toberkoe.fluentassertions.api.objects.AbstractObjectAssert;
import de.toberkoe.fluentassertions.internal.DateConverter;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateAssert extends AbstractObjectAssert<DateAssert, Date> {

    private static final DateFormat dateFormat = DateFormat.getDateTimeInstance();

    public DateAssert(Date value) {
        super(value);
    }

    public DateAssert isBefore(Date otherDate) {
        if (value.before(otherDate)) {
            return instance;
        }
        throw error("Expected %s to be before %s", dateFormat.format(value), dateFormat.format(otherDate));
    }

    public DateAssert isAfter(Date otherDate) {
        if (value.after(otherDate)) {
            return instance;
        }
        throw error("Expected %s to be after %s", dateFormat.format(value), dateFormat.format(otherDate));
    }

    public DateAssert isToday() {
        LocalDate date = DateConverter.toLocalDate(value);
        if (LocalDate.now().equals(date)) {
            return instance;
        }
        throw error("Expected %s to be today", dateFormat.format(value));
    }

    public DateAssert isYesterday() {
        LocalDate date = DateConverter.toLocalDate(value);
        if (LocalDate.now().minusDays(1).equals(date)) {
            return instance;
        }
        throw error("Expected %s to be yesterday", dateFormat.format(value));
    }

    public DateAssert isTomorrow() {
        LocalDate date = DateConverter.toLocalDate(value);
        if (LocalDate.now().plusDays(1).equals(date)) {
            return instance;
        }
        throw error("Expected %s to be tomorrow", dateFormat.format(value));
    }

    public DateAssert isEqualTo(LocalDate expected) {
        return super.isEqualTo(DateConverter.fromLocalDate(expected));
    }

    public DateAssert isNotEqualTo(LocalDate expected) {
        return super.isNotEqualTo(DateConverter.fromLocalDate(expected));
    }

    public DateAssert isInPastIgnoringTime() {
        LocalDate actual = DateConverter.toLocalDate(value);
        LocalDate now = LocalDate.now();
        if (actual.isBefore(now)) {
            return instance;
        }
        throw error("Expected %s to be in past", dateFormat.format(value));
    }

    public DateAssert isInFutureIgnoringTime() {
        LocalDate actual = DateConverter.toLocalDate(value);
        LocalDate now = LocalDate.now();
        if (actual.isAfter(now)) {
            return instance;
        }
        throw error("Expected %s to be in future", dateFormat.format(value));
    }

}
