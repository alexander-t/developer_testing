package corejava;

public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        assert hour >= 0 && hour < 24 :
                "Hour out of range";
        assert minute >= 0 && minute < 60 :
                "Minute out of range";
        this.hour = hour;
        this.minute = minute;
    }


}
