package case_study.services.implement.booking;

import case_study.models.Booking;

import java.util.Comparator;

public class BookingCompareByDate implements Comparator<Booking> {

    @Override
    public int compare(Booking o1, Booking o2) {
        if (o1.getStartDate().equals(o2.getStartDate())) {
            return o1.getEndDate().compareTo(o2.getEndDate());
        } else {
            return o1.getStartDate().compareTo(o2.getStartDate());
        }
    }

}
