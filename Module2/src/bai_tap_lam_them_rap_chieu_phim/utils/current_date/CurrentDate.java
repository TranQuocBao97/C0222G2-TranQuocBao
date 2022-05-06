package bai_tap_lam_them_rap_chieu_phim.utils.current_date;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class CurrentDate {
    public static String getCurrentDate(){
        String currentDay = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("k:m dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        System.out.println(simpleDateFormat.format(calendar.getTime()));
        return currentDay;
    }

    public static void main(String[] args) {
        getCurrentDate();
    }
}
