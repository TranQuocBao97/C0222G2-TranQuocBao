package test.GiaiThuat1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        String str = dateFormat.format(calendar.getTime());
        Date date = calendar.getTime();
        System.out.println("TIME NOW: "+str);
        System.out.println(date.getTime());
    }
}
