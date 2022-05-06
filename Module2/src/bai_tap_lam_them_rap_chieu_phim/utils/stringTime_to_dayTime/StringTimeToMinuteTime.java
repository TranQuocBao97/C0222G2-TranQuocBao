package bai_tap_lam_them_rap_chieu_phim.utils.stringTime_to_dayTime;

import bai_tap_lam_them_rap_chieu_phim.utils.stringTime_to_millisecond.StringTimeToMillisecond;

public class StringTimeToMinuteTime {
    public static Integer getDayTimeTypeMinute(String dateTimeString){
        Integer dayTime = Math.toIntExact(StringTimeToMillisecond.getTimeByMillisecond(dateTimeString) / (1000 * 60));
        return dayTime;
    }

}
