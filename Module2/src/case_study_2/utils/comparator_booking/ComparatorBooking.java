package case_study_2.utils.comparator_booking;

import case_study_2.models.Booking;
import case_study_2.utils.compareTime.DateString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class ComparatorBooking implements Comparator<Booking> {


    @Override
    public int compare(Booking o1, Booking o2) {
        int daysStart1 = DateString.swapToIntegerDay(o1.getDayStart());
        int daysEnd1 = DateString.swapToIntegerDay(o1.getDayEnd());
        int daysStart2 = DateString.swapToIntegerDay(o2.getDayStart());
        int daysEnd2 = DateString.swapToIntegerDay(o2.getDayEnd());

        if (daysStart1 > daysStart2) {
            return daysStart1 - daysStart2;
        } else if (daysStart2 > daysStart1) {
            return daysStart2 - daysStart1;
        } else if (daysEnd1 > daysEnd2) {
            return daysEnd2 - daysEnd1;
        } else if (daysEnd2 > daysEnd1) {
            return daysEnd1 - daysEnd2;
        } else if (o1.getIdFacility().equals(o2.getIdFacility())) {
            return 0;
        } else {
            return 0;
        }
    }
}
