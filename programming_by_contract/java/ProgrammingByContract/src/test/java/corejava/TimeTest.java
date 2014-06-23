package corejava;

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

    // Fails with an assertion error
    @Test
    public void negativeHourNotAccepted() {
        new Time(-1, 1);
    }

    // Fails with an assertion error
    @Test
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

    // Fails with an assertion error
    @Test
    public void negativeMinuteNotAccepted() {
        new Time(0, -1);
    }

    // Fails with an assertion error
    @Test
    public void minutesGreaterThan59AreInvalid() {
        new Time(1, 60);
    }
}
