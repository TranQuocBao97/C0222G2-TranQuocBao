package case_study.models;

import java.util.Objects;

public class Booking {
    private String informationCustomerBooking;
    private String informationFacilityBooking;
    private Integer startDate;
    private Integer endDate;

    public Booking() {
    }

    public Booking(String informationCustomerBooking, String informationFacilityBooking, Integer startDate, Integer endDate) {
        this.informationCustomerBooking = informationCustomerBooking;
        this.informationFacilityBooking = informationFacilityBooking;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getInformationCustomerBooking() {
        return informationCustomerBooking;
    }

    public void setInformationCustomerBooking(String informationCustomerBooking) {
        this.informationCustomerBooking = informationCustomerBooking;
    }

    public String getInformationFacilityBooking() {
        return informationFacilityBooking;
    }

    public void setInformationFacilityBooking(String informationFacilityBooking) {
        this.informationFacilityBooking = informationFacilityBooking;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Information Customer Booking: " + informationCustomerBooking +
                ", InformationFacilityBooking: " + informationFacilityBooking +
                ", startDate: " + startDate +
                ", endDate: " + endDate + ".";
    }

//    @Override
//    public int compareTo(Booking o) {
//        if (this.getStartDate().equals(o.getStartDate())) {
//            return this.getEndDate().compareTo(o.getEndDate());
//        } else {
//            return this.getStartDate().compareTo(o.getStartDate());
//        }
//    }

    @Override
    public boolean equals(Object o) {
        Booking booking = (Booking) o;
        if (Objects.equals(informationFacilityBooking, booking.informationFacilityBooking)) {
            if(booking.startDate<endDate && booking.startDate>=startDate){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(1);
    }
}
