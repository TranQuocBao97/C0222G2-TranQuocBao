package case_study_2.models;

import case_study_2.utils.compareTime.BookingTimeCompare;

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
        return "Booking{" +
                "dayStart='" + dayStart + '\'' +
                ", dayEnd='" + dayEnd + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", idFacility='" + idFacility + '\'' +
                '}';
    }

    public String propertiesToCsv() {
        return this.dayStart + "," + this.dayEnd + "," + this.idCustomer + "," + this.idFacility;
    }

    @Override
    public boolean equals(Object o) {
        Booking booking = (Booking) o;
        return Objects.equals(this.idFacility, booking.idFacility);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
