package case_study_2.models;

import case_study_2.utils.compareTime.BookingTimeCompare;
import case_study_2.utils.compareTime.DateString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking implements Comparable<Booking> {
    private String dayStart;
    private String dayEnd;
    private String idCustomer;
    private String idFacility;

    public Booking() {
    }

    public Booking(String dayStart, String dayEnd, String idCustomer, String idFacility) {
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.idCustomer = idCustomer;
        this.idFacility = idFacility;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(String idFacility) {
        this.idFacility = idFacility;
    }

    @Override
    public String toString() {
        return "[Booking: " +
                "dayStart: " + dayStart +
                " - dayEnd: " + dayEnd +
                " - idCustomer: " + idCustomer +
                " - idFacility: " + idFacility + "] ";
    }

    public String propertiesToCsv() {
        return this.dayStart + "," + this.dayEnd + "," + this.idCustomer + "," + this.idFacility;
    }

    @Override
    public boolean equals(Object o) {
//        Booking booking = (Booking) o;
//        int dayStart1 = DateString.swapToIntegerDay(getDayStart());
//        int dayEnd1 = DateString.swapToIntegerDay(getDayEnd());
//        int dayStart2 = DateString.swapToIntegerDay(booking.getDayStart());
//        int dayEnd2 = DateString.swapToIntegerDay(booking.getDayEnd());
////        if (idFacility.equals(booking.getIdFacility())) {
////            if (dayStart1 == dayStart2) {
////                return true;
////            } else if (dayStart2 > dayStart1 && dayStart2 < dayEnd1) {
////                return true;
////            } else if (dayStart1 > dayStart2 && dayStart1 < dayEnd2) {
////                return true;
////            }
////        }
        return true;
    }

//    public static void main(String[] args) {
//        Booking booking1 = new Booking("11/05/2022","15/05/2022","15","SVVL-0001");
//        Booking booking2 = new Booking("13/05/2022","14/05/2022","16","SVVL-0002");
//        Booking booking3 = new Booking("12/05/2022","14/05/2022","16","SVVL-0001");
//        Booking booking4 = new Booking("10/05/2022","12/05/2022","16","SVVL-0001");
//        System.out.println(booking1.equals(booking2));
//        Set<Booking> bookingSet = new TreeSet<>();
//        bookingSet.add(booking1);
//        bookingSet.add(booking2);
//        bookingSet.add(booking3);
//        bookingSet.add(booking4);
//        for(Booking booking : bookingSet){
//            System.out.println(booking);
//        }
//    }

    @Override
    public int hashCode() {
        return Objects.hash(idFacility);
    }

    @Override
    public int compareTo(Booking o) {
        int daysStart1 = DateString.swapToIntegerDay(getDayStart());
        int daysEnd1 = DateString.swapToIntegerDay(getDayEnd());
        int daysStart2 = DateString.swapToIntegerDay(o.getDayStart());
        int daysEnd2 = DateString.swapToIntegerDay(o.getDayEnd());

        if (getIdFacility().equals(o.getIdFacility())) {
            if (daysStart1 == daysStart2) {
                return 0;
            } else if (daysStart2 > daysStart1 && daysStart2 < daysEnd1) {
                return 0;
            } else if (daysStart1 > daysStart2 && daysStart1 < daysEnd2) {
                return 0;
            } else if (daysStart1 < daysStart2) {
                return -1;
            } else if (daysStart1 > daysStart2) {
                return 1;
            } else if (daysEnd1 < daysEnd2) {
                return -1;
            } else if (daysEnd1 > daysEnd2) {
                return 1;
            } else {
                return -1;
            }
        } else if (daysStart1 < daysStart2) {
            return -1;
        } else if (daysStart1 > daysStart2) {
            return 1;
        } else if (daysEnd1 < daysEnd2) {
            return -1;
        } else if (daysEnd1 > daysEnd2) {
            return 1;
        } else {
            return -1;
        }
    }
}
