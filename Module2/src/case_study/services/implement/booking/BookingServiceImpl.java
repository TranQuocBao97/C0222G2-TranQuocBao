package case_study.services.implement.booking;

import case_study.models.Booking;
import case_study.services.IBookingService;
import case_study.services.implement.facility_implement.FacilityServiceImpl;
import case_study.services.implement.person_implement.CustomerServiceImpl;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingServiceImpl implements IBookingService{
    static Scanner scanner = new Scanner(System.in);
    private static CustomerServiceImpl customerService = new CustomerServiceImpl();
    private static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    private static Set<Booking> bookingList = new TreeSet<>( new BookingCompareByDate());



    static {
        bookingList.add(new Booking(customerService.select(212420254),facilityService.select(2),12,13));
        bookingList.add(new Booking(customerService.select(205475885),facilityService.select(1),12,14));
        bookingList.add(new Booking(customerService.select(278445231),facilityService.select(4),11,14));
    }

    @Override
    public void add() {
        customerService.display();
        System.out.println("Select customer by id citizen: ");
        Integer selectIdCustomer = Integer.parseInt(scanner.nextLine());
        String customerInformation = null;
        if(customerService.select(selectIdCustomer)!=null){
            customerInformation = customerService.select(selectIdCustomer);
        }

        facilityService.display();
        System.out.println("Select Facility by id facility: ");
        Integer selectIdFacility = Integer.parseInt(scanner.nextLine());
        String facilityInformation = null;
        if(facilityService.select(selectIdFacility)!=null){
            facilityInformation = facilityService.select(selectIdFacility);
        }

        System.out.println("Enter start Date: ");
        Integer startDate = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter end Date: ");
        Integer endDate = Integer.parseInt(scanner.nextLine());

        bookingList.add(new Booking(customerInformation,facilityInformation,startDate,endDate));
    }

    @Override
    public void display() {
        for (Booking booking : bookingList){
            System.out.println(booking);
        }
    }

    @Override
    public void edit() {

    }

}
