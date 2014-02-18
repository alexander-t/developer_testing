package util;

import java.util.Calendar;
import java.util.Date;

/**
 * Emulating every legacy system's own implementation of date utilities.
 * Even using deprecated methods :)
 */
public class DateUtils {
    public static long diffTime(Date t1, Date t2) {
        if (t1.getDate() != t2.getDate()) {
            throw new IllegalArgumentException("Incomparable dates");
        }
        return (t2.getHours() - t1.getHours()) * 60;
    }

    public static long diffTime_revised(Date t1, Date t2) {
        if (t1.getDate() != t2.getDate()) {
            throw new IllegalArgumentException("Incomparable dates");
        }
        return (t2.getHours() * 60 + t2.getMinutes())
                - (t1.getHours() * 60 + t1.getMinutes());
    }

    public static void main(String[] args) {
        Date d1 = Calendar.getInstance().getTime();

        Calendar c2 = Calendar.getInstance();
        c2.add(Calendar.HOUR, 1);
       c2.add(Calendar.MINUTE, 27);
        System.err.println(diffTime(d1, c2.getTime()));
    }
}
