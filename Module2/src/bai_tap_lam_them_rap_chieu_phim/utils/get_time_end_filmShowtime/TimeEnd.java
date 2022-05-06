package bai_tap_lam_them_rap_chieu_phim.utils.get_time_end_filmShowtime;

import sun.font.CreatedFontTracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TimeEnd {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("kk:mm dd/MM/yyyy");
    static Scanner scanner = new Scanner(System.in);
    public static String getTimeEnd(String timeStart,Integer filmTime){
        Date timeStartDateType = null;
        Date timeEndDateType = null;
        String timeEnd = null;
        try {
            timeStartDateType = simpleDateFormat.parse(timeStart);
            long timeEndStringMillisecond = timeStartDateType.getTime()+filmTime*60*1000;
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(timeEndStringMillisecond);
            timeEnd = simpleDateFormat.format(calendar.getTime());
        } catch (Exception e) {
            System.out.println("time start is not right");
        }
        return timeEnd;
    }
}
