package case_study_2.utils.comparator_booking;

import case_study_2.models.Booking;

import java.util.Comparator;

public class ComparatorBooking implements Comparator<Booking> {


    @Override
    public int compare(Booking o1, Booking o2) {
        return o1.getDayStart().compareTo(o2.getDayStart());
    }
}
