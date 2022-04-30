package test.test_day_comparator;

import case_study_2.services.class_implement.booking_implement.BookingServiceImpl;

import java.util.Calendar;
import java.util.Date;

public class GetMonth {
    public static void main(String[] args) {
        Date date= new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        System.out.println(month+1);
    }
}
