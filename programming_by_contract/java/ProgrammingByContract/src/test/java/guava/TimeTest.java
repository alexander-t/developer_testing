package guava;

import org.junit.Test;

public class TimeTest {

    @Test
    public void validHours() {
        new Time(0, 1);
        new Time(1, 1);
        new Time(15, 1);
        new Time(22, 1);
        new Time(23, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeHourNotAccepted() {
        new Time(-1, 1);
        //Objects.requireNonNull()
    }

    @Test(expected = IllegalArgumentException.class)
    public void hoursGreaterThan23AreInvalid() {
        new Time(24, 1);
    }

    @Test
    public void validMinutes() {
        new Time(0, 0);
        new Time(0, 1);
        new Time(0, 30);
        new Time(0, 58);
        new Time(0, 59);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeMinuteNotAccepted() {
        new Time(0, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void minutesGreaterThan59AreInvalid() {
        new Time(1, 60);
    }
}
