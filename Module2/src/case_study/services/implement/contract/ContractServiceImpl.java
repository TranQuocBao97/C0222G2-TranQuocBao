package case_study.services.implement.contract;

import case_study.models.Contract;
import case_study.models.person.sub_person.Customer;
import case_study.services.implement.booking.BookingServiceImpl;

import java.util.*;

public class ContractServiceImpl {
    static Scanner scanner = new Scanner(System.in);
    private static BookingServiceImpl bookingService = new BookingServiceImpl();
    private static Queue<Contract> contractList = new LinkedList<>();
    public void add(){
        bookingService.display();
    }
}
