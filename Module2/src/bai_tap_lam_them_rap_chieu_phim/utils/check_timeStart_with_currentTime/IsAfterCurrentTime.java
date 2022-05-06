package bai_tap_lam_them_rap_chieu_phim.utils.check_timeStart_with_currentTime;

import bai_tap_lam_them_rap_chieu_phim.utils.current_date.CurrentDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class IsAfterCurrentTime {
    static SimpleDateFormat simpleDateFormatWithTime = new SimpleDateFormat("kk:mm dd/MM/yyyy");
    public static boolean checkTimeStartWithCurrent(String timeStart){
        Date dateTimeStart = null;
        Date dateCurrent = null;
        long timeStartMilli = 0;
        long timeCurrentMilli = 0;
        try {
            dateTimeStart = simpleDateFormatWithTime.parse(timeStart);
            timeStartMilli = dateTimeStart.getTime();
            dateCurrent = simpleDateFormatWithTime.parse(CurrentDate.getCurrentDateWithTime());
            timeCurrentMilli = dateCurrent.getTime();
        } catch (Exception e) {
            System.out.println("Date data has problem");
        }
        return timeStartMilli>timeCurrentMilli;
    }

}
