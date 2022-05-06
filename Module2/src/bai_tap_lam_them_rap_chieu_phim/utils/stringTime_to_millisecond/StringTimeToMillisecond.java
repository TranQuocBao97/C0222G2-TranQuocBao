package bai_tap_lam_them_rap_chieu_phim.utils.stringTime_to_millisecond;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringTimeToMillisecond {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("kk:mm dd/MM/yyyy");
    public static long getTimeByMillisecond(String dateTimeString){
        Date timeDateType;
        long timeByMillisecond = 0;
        try {
            timeDateType = simpleDateFormat.parse(dateTimeString);
            timeByMillisecond = timeDateType.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeByMillisecond;
    }
}
