package de.toberkoe.fluentassertions.api.date;

import de.toberkoe.fluentassertions.internal.DateConverter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static de.toberkoe.fluentassertions.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DateAssertTest {

    private Date today = new Date();
    private Date yesterday = DateConverter.fromLocalDate(LocalDate.now().minusDays(1));
    private Date tomorrow = DateConverter.fromLocalDate(LocalDate.now().plusDays(1));

    @Test
    void isBefore() {
        assertThat(yesterday).isBefore(today);
        assertThrows(AssertionError.class, () -> assertThat(today).isBefore(yesterday));
    }

    @Test
    void isAfter() {
        assertThat(tomorrow).isAfter(today);
        assertThrows(AssertionError.class, () -> assertThat(yesterday).isAfter(today));
    }

    @Test
    void isToday() {
        assertThat(today).isToday();
        assertThrows(AssertionError.class, () -> assertThat(yesterday).isToday());
    }

    @Test
    void isYesterday() {
        assertThat(yesterday).isYesterday();
        assertThrows(AssertionError.class, () -> assertThat(today).isYesterday());
    }

    @Test
    void isTomorrow() {
        assertThat(tomorrow).isTomorrow();
        assertThrows(AssertionError.class, () -> assertThat(today).isTomorrow());
    }

    @Test
    void isEqualTo() {
        Date todayNulled = DateConverter.fromLocalDate(LocalDate.now());
        assertThat(todayNulled).isEqualTo(DateConverter.toLocalDate(today));
        assertThat(today).isEqualTo(today);
        assertThrows(AssertionError.class, () -> assertThat(yesterday).isEqualTo(new Date()));
        assertThrows(AssertionError.class, () -> assertThat(yesterday).isEqualTo(LocalDate.now()));
    }

    @Test
    void isNotEqualTo() {
        assertThat(yesterday).isNotEqualTo(new Date());
        assertThat(yesterday).isNotEqualTo(LocalDate.now());
        assertThrows(AssertionError.class, () -> assertThat(yesterday).isNotEqualTo(yesterday));
        assertThrows(AssertionError.class, () -> assertThat(today).isNotEqualTo(today));
    }

    @Test
    void isInPastIgnoringTime() {
        assertThat(yesterday).isInPastIgnoringTime();
        assertThrows(AssertionError.class, () -> assertThat(today).isInPastIgnoringTime());
    }

    @Test
    void isInFutureIgnoringTime() {
        assertThat(tomorrow).isInFutureIgnoringTime();
        assertThrows(AssertionError.class, () -> assertThat(today).isInFutureIgnoringTime());
    }

    @Test
    void isNull() {
        assertThat((Date) null).isNull();
    }

    @Test
    void isNotNull() {
        assertThat(today).isNotNull();
    }

    @Test
    void isSameAs() {
        assertThat(today).isSameAs(today);
    }

    @Test
    void isNotSameAs() {
        assertThat(today).isNotSameAs(yesterday);
    }

    @Test
    void isInstanceOf() {
        assertThat(today).isInstanceOf(Date.class);
    }

    @Test
    void isNotInstanceOf() {
        assertThat(today).isNotInstanceOf(LocalDate.class);
    }

    @Test
    void isInstanceOfAny() {
        assertThat(today).isInstanceOfAny(String.class, Date.class);
    }

    @Test
    void isNotInstanceOfAny() {
        assertThat(today).isNotInstanceOfAny(String.class, LocalDate.class);
    }
}