package test.test_day_comparator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        String time1 = "01/02/1970";
        String time2 = "01/03/1970";
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = new Date(time1);
        Date date2 = new Date(time2);
//        System.out.println(new Date(99, 2, 12).before(new Date (99, 2, 18)));
        System.out.println(date1.getTime());
        System.out.println(date2.getTime());
        System.out.println(date2.getTime()-date1.getTime());

    }
}
