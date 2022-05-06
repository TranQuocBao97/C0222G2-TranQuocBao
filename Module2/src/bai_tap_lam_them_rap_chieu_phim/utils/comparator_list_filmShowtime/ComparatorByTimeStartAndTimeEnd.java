package bai_tap_lam_them_rap_chieu_phim.utils.comparator_list_filmShowtime;

import bai_tap_lam_them_rap_chieu_phim.models.FilmShowtime;
import bai_tap_lam_them_rap_chieu_phim.utils.stringTime_to_dayTime.StringTimeToMinuteTime;

import java.util.Comparator;

public class ComparatorByTimeStartAndTimeEnd implements Comparator<FilmShowtime> {
    @Override
    public int compare(FilmShowtime o1, FilmShowtime o2) {
        Integer timeStart1 = StringTimeToMinuteTime.getDayTimeTypeMinute(o1.getTimeStart());
        Integer timeEnd1 = StringTimeToMinuteTime.getDayTimeTypeMinute(o1.getTimeEnd());
        Integer timeStart2 = StringTimeToMinuteTime.getDayTimeTypeMinute(o2.getTimeStart());
        Integer timeEnd2 = StringTimeToMinuteTime.getDayTimeTypeMinute(o2.getTimeEnd());
        if(!timeStart1.equals(timeStart2)){
            return timeStart1-timeStart2;
        }else {
            return timeEnd1-timeEnd2;
        }
    }
}
