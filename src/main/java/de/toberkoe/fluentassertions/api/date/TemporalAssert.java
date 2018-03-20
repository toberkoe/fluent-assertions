package de.toberkoe.fluentassertions.api.date;

import de.toberkoe.fluentassertions.api.objects.AbstractObjectAssert;

import java.time.temporal.Temporal;

public abstract class TemporalAssert<S extends TemporalAssert<S, T>, T extends Temporal> extends AbstractObjectAssert<S, T> {

    protected TemporalAssert(T value) {
        super(value);
    }

    public S isBefore(T otherValue) {
        if (isValueBefore(otherValue)) {
            return instance;
        }
        throw error("Exptected to be before %s but was %s", otherValue, value);
    }

    public S isAfter(T otherValue) {
        if (isValueAfter(otherValue)) {
            return instance;
        }
        throw error("Exptected to be after %s but was %s", otherValue, value);
    }

    public S isInPast() {
        if (isValueInPast()) {
            return instance;
        }
        throw error("Exptected to be in past but was %s", value);
    }

    public S isInFuture() {
        if (isValueInFuture()) {
            return instance;
        }
        throw error("Exptected to be in future but was %s", value);
    }

    public S isToday() {
        if (isValueToday()) {
            return instance;
        }
        throw error("Exptected to be today but was %s", value);
    }

    public S isYesterday() {
        if (isValueYesterday()) {
            return instance;
        }
        throw error("Exptected to be yesterday but was %s", value);
    }

    public S isTomorrow() {
        if (isValueTomorrow()) {
            return instance;
        }
        throw error("Exptected to be tomorrow but was %s", value);
    }

    protected abstract boolean isValueBefore(T otherValue);

    protected abstract boolean isValueAfter(T otherValue);

    protected abstract boolean isValueInPast();

    protected abstract boolean isValueInFuture();

    protected abstract boolean isValueToday();

    protected abstract boolean isValueYesterday();

    protected abstract boolean isValueTomorrow();

}
