package de.toberkoe.fluentassertions.api.date;

import de.toberkoe.fluentassertions.api.objects.AbstractObjectAssert;

import java.time.LocalTime;

public class LocalTimeAssert extends AbstractObjectAssert<LocalTimeAssert, LocalTime> {

    public LocalTimeAssert(LocalTime value) {
        super(value);
    }

    public LocalTimeAssert isBefore(LocalTime otherValue) {
        if (value.isBefore(otherValue)) {
            return instance;
        }
        throw error("Exptected to be before %s but was %s", otherValue, value);
    }

    public LocalTimeAssert isAfter(LocalTime otherValue) {
        if (value.isAfter(otherValue)) {
            return instance;
        }
        throw error("Exptected to be after %s but was %s", otherValue, value);
    }

    public LocalTimeAssert isInPast() {
        if (value.isBefore(LocalTime.now())) {
            return instance;
        }
        throw error("Exptected to be in past but was %s", value);
    }

    public LocalTimeAssert isInFuture() {
        if (value.isAfter(LocalTime.now())) {
            return instance;
        }
        throw error("Exptected to be in future but was %s", value);
    }

}
