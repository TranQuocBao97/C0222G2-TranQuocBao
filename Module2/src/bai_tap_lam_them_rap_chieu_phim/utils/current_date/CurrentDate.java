package bai_tap_lam_them_rap_chieu_phim.utils.current_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CurrentDate {
    static SimpleDateFormat simpleDateFormatWithTime = new SimpleDateFormat("kk:mm dd/MM/yyyy");

    static Calendar calendar = Calendar.getInstance();
    public static String getCurrentDateWithTime(){
        return simpleDateFormatWithTime.format(calendar.getTime());
    }
}
