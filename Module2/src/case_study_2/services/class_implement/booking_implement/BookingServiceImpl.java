package case_study_2.services.class_implement.booking_implement;


import case_study_2.models.Booking;
import case_study_2.services.IBookingService;
import case_study_2.services.class_implement.facility_implement.FacilityServiceImpl;
import case_study_2.services.class_implement.facility_implement.HouseServiceImpl;
import case_study_2.services.class_implement.facility_implement.RoomServiceImpl;
import case_study_2.services.class_implement.facility_implement.VillaServiceImpl;
import case_study_2.services.class_implement.person_implement.CustomerServiceImpl;
import case_study_2.utils.ReadFile;
import case_study_2.utils.WriteFile;
import case_study_2.utils.compareTime.BookingTimeCompare;
import case_study_2.utils.compareTime.DateString;
import case_study_2.utils.current_time.CurrentTime;
import case_study_2.utils.take_data_input_by_regex.RegexService;

import java.util.*;

public class BookingServiceImpl implements IBookingService {
    private static final Scanner scanner = new Scanner(System.in);
    static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    private static final String FILE_DATA_BOOKING = "src/case_study_2/data/File_Data_Booking.csv";
    private static final String FILE_DATA_BOOKING_QUEUE = "src/case_study_2/data/File_Data_Booking_Queue.csv";
    private static final Set<Booking> bookingList;
    private static final Queue<Booking> bookingQueueList;

    static {
        bookingList = ReadFile.bookingListFromFileData(FILE_DATA_BOOKING);
        bookingQueueList = ReadFile.bookingQueueListFromFileData(FILE_DATA_BOOKING_QUEUE);
        checkBookingUseByMonth();
    }

    public Booking addToContractList() {
        Booking booking = bookingQueueList.poll();
        updateBookingQueue();
        return booking;
    }
    public void updateBookingQueue(){
        WriteFile.writeBookingQueueListToCsv(FILE_DATA_BOOKING_QUEUE,bookingQueueList,false);
    }

    public static void displayBookingQueueList(){
        int stt = 0;
        for(Booking booking : bookingQueueList){
            System.out.println("STT."+(++stt)+" : "+booking);
        }
    }

    public static void checkBookingUseByMonth() {
        String[] currentTime = CurrentTime.getCurrentTime().split("/");
        Integer currentMonth = Integer.parseInt(currentTime[1]);
        for (Booking booking : bookingList) {
            String[] arrayTime = booking.getDayStart().split("/");
            Integer monthBooking = Integer.parseInt(String.valueOf(arrayTime[1]));
            String idFacility = booking.getIdFacility();
            Integer countUse = 0;
            if (Objects.equals(currentMonth, monthBooking)) {
                for (Booking booking1 : bookingList) {
                    if (booking1.getIdFacility().equals(idFacility)) {
                        ++countUse;
                    }
                }
                VillaServiceImpl.countUseInMonth(idFacility, countUse);
                HouseServiceImpl.countUseInMonth(idFacility, countUse);
                RoomServiceImpl.countUseInMonth(idFacility, countUse);
            } else if (currentMonth > monthBooking) {
                for (Booking booking1 : bookingList) {
                    if (booking1.getIdFacility().equals(idFacility)) {
                        --countUse;
                    }
                }
                VillaServiceImpl.countUseInMonth(idFacility, countUse);
                HouseServiceImpl.countUseInMonth(idFacility, countUse);
                RoomServiceImpl.countUseInMonth(idFacility, countUse);
            }

        }
    }


    @Override
    public void add() {
        boolean flag;
        String dayStart = "";
        do {
            flag = false;
            System.out.println("Current time: " + CurrentTime.getCurrentTime());
            System.out.print("Enter start day for rent (over (or equals) than current time ): ");
            dayStart = RegexService.checkDateTimeFormat(scanner.nextLine());
            if (DateString.checkIsADate(dayStart) && DateString.swapToIntegerDay(dayStart) > DateString.swapToIntegerDay(CurrentTime.getCurrentTime())) {
                flag = true;
            }
        } while (flag == false);

        String dayEnd = "";
        do {
            flag = false;
            System.out.println("Day start: " + dayStart);
            System.out.print("Enter end day for rent (over than start day): ");
            dayEnd = RegexService.checkDateTimeFormat(scanner.nextLine());
            if (DateString.checkIsADate(dayEnd) && DateString.swapToIntegerDay(dayEnd) > DateString.swapToIntegerDay(dayStart)) {
                flag = true;
            }
        } while (flag == false);


        String idCustomer = CustomerServiceImpl.selectIdCustomer();
        String idFacility = facilityService.selectIdFacility();
        bookingList.add(new Booking(dayStart, dayEnd, idCustomer, idFacility));
        WriteFile.writeBookingListToCsv(FILE_DATA_BOOKING, bookingList, false);

        bookingQueueList.add(new Booking(dayStart,dayEnd,idCustomer,idFacility));
        WriteFile.writeBookingQueueListToCsv(FILE_DATA_BOOKING_QUEUE,bookingQueueList,false);
    }


    @Override
    public void display() {
        for (Booking booking : bookingList) {
            System.out.println(booking.toString());
        }
    }

    @Override
    public void edit() {

    }
}
