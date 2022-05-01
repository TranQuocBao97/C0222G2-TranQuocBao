package case_study_2.utils.comparator_booking;

import case_study_2.models.Booking;
import case_study_2.utils.compareTime.DateString;


import java.util.Comparator;


public class ComparatorBooking implements Comparator<Booking> {


    @Override
    public int compare(Booking o1, Booking o2) {
        int daysStart1 = DateString.swapToIntegerDay(o1.getDayStart());
        int daysEnd1 = DateString.swapToIntegerDay(o1.getDayEnd());
        int daysStart2 = DateString.swapToIntegerDay(o2.getDayStart());
        int daysEnd2 = DateString.swapToIntegerDay(o2.getDayEnd());

        if(daysStart1<daysStart2){
            return -1;
        }else if(daysStart1>daysStart2){
            return 1;
        }else if(daysEnd1<daysEnd2){
            return -1;
        }else if(daysEnd1>daysEnd2){
            return 1;
        }else if(o1.getIdFacility().equals(o2.getIdFacility())){
            return 0;
        }else {
            return -1;
        }
    }
}
