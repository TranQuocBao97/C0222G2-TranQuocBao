package case_study_2.models;

import case_study_2.utils.compareTime.BookingTimeCompare;
import case_study_2.utils.compareTime.DateString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
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
        Booking booking = (Booking) o;
        Integer dayStart1 =  DateString.swapToIntegerDay(getDayStart());
        Integer dayEnd1 = DateString.swapToIntegerDay(getDayEnd());
        Integer dayStart2 = DateString.swapToIntegerDay(booking.getDayStart());
        Integer dayEnd2 = DateString.swapToIntegerDay(booking.getDayEnd());
        if(idFacility.equals(booking.getIdFacility())){
            if(dayStart1.equals(dayStart2)){
                return true;
            }else if(dayStart2>=dayStart1 && dayStart2<dayEnd1){
                return true;
            }else return dayStart1 >= dayStart2 && dayStart1 < dayEnd2;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFacility);
    }
}
