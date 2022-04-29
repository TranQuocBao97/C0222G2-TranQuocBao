package case_study_2.services.class_implement.booking_implement;


import case_study_2.models.Booking;
import case_study_2.services.IBookingService;
import case_study_2.services.class_implement.facility_implement.FacilityServiceImpl;
import case_study_2.services.class_implement.person_implement.CustomerServiceImpl;
import case_study_2.utils.ReadFile;
import case_study_2.utils.WriteFile;
import case_study_2.utils.comparator_booking.ComparatorBooking;
import case_study_2.utils.take_data_input_by_regex.RegexService;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingServiceImpl implements IBookingService {
    private static final Scanner scanner = new Scanner(System.in);
    static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    private static final String FILE_DATA_BOOKING = "src/case_study_2/data/File_Data_Booking.csv";
    private static Set<Booking> bookingList = new TreeSet<>(new ComparatorBooking());

    static {
        bookingList = ReadFile.bookingListFromFileData(FILE_DATA_BOOKING);
    }


    @Override
    public void add() {
        System.out.print("Enter start day for rent: ");
        String dayStart = RegexService.checkDateTimeFormat(scanner.nextLine());
        System.out.print("Enter end day for rent: ");
        String dayEnd = RegexService.checkDateTimeFormat(scanner.nextLine());
        String idCustomer = CustomerServiceImpl.selectIdCustomer();
        String idFacility = facilityService.selectIdFacility();
        bookingList.add(new Booking(dayStart.toString(),dayEnd.toString(),idCustomer.toString(),idFacility.toString()));
        WriteFile.writeBookingListToCsv(FILE_DATA_BOOKING,bookingList,false);
    }


    @Override
    public void display() {

    }

    @Override
    public void edit() {

    }
}
