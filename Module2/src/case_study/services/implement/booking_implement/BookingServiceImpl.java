package case_study.services.implement.booking_implement;

import case_study.controllers.managementController.BookingController;
import case_study.models.Booking;
import case_study.models.Contract;
import case_study.services.IBookingService;
import case_study.services.implement.facility_implement.FacilityServiceImpl;
import case_study.services.implement.person_implement.CustomerServiceImpl;

import java.util.*;

public class BookingServiceImpl implements IBookingService{
    static Scanner scanner = new Scanner(System.in);
    private static CustomerServiceImpl customerService = new CustomerServiceImpl();
    private static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    private static Set<Booking> bookingList = new TreeSet<>( new BookingCompareByDate());
    private static List<Contract> contractList = new LinkedList<>();
    static Integer idBooking = 1;

    static {
        contractList.add(new Contract(idBooking++,customerService.select(4),facilityService.select(3),5,10,100000,5000000));
        contractList.add(new Contract(idBooking++,customerService.select(3),facilityService.select(8),6,11,100000,6000000));
        contractList.add(new Contract(idBooking++,customerService.select(6),facilityService.select(9),7,12,150000,40000000));
        contractList.add(new Contract(idBooking++,customerService.select(7),facilityService.select(3),8,9,200000,1000000));
        contractList.add(new Contract(idBooking++,customerService.select(8),facilityService.select(2),7,10,120000,2000000));
    }

    static {
        bookingList.add(new Booking(idBooking++,customerService.select(3),facilityService.select(2),12,15));
        bookingList.add(new Booking(idBooking++,customerService.select(2),facilityService.select(1),12,16));
        bookingList.add(new Booking(idBooking++,customerService.select(1),facilityService.select(4),11,14));
        bookingList.add(new Booking(idBooking++,customerService.select(5),facilityService.select(7),11,18));
    }

    public List<String> customerHaveContract(){
        List<String> customerContractList = new ArrayList<>();
        for (int i = 0; i <contractList.size() ; i++) {
            customerContractList.add(contractList.get(i).getInformationCustomerBooking());
        }
        return customerContractList;
    }

    public Integer countContractList(){
        return contractList.size();
    }

    public void addContract(){
        Queue<Booking> bookingQueueList = new LinkedList<>();
        bookingQueueList.addAll(bookingList);
        while (true){
            display();
            System.out.println("Add 1 contract by first next booking data: ");
            System.out.println("1. yes");
            System.out.println("2. no");
            Integer pickAddContract = Integer.parseInt(scanner.nextLine());
            switch (pickAddContract){
                case 1:
                    Integer idBookingContract =  bookingQueueList.peek().getIdBooking();
                    String customerContract = bookingQueueList.peek().getInformationCustomerBooking();
                    String facilityContract = bookingQueueList.peek().getInformationFacilityBooking();
                    Integer startDate = bookingQueueList.peek().getStartDate();
                    Integer endDate = bookingQueueList.peek().getEndDate();
                    System.out.print("Deposit Money: ");
                    Double depositMoney = Double.parseDouble(scanner.nextLine());
                    Integer price = facilityService.checkPriceFacility(bookingQueueList.peek().getInformationFacilityBooking());
                    Double totalMoney = (Math.abs(startDate-endDate)*(double)price);
                    contractList.add(new Contract(idBookingContract,customerContract,facilityContract,startDate,endDate,depositMoney,totalMoney));
                    bookingList.remove(bookingQueueList.peek());
                    BookingController.bookingMenu();
                    break;
                case 2:
                    BookingController.bookingMenu();
                    break;
                case 3:
                    System.out.println("Please Enter right number to pick");
            }
        }

    }

    public void displayContract(){
        Integer stt = 1;
        for(Contract contract : contractList){
            System.out.println(stt+". "+contract);
            stt++;
        }
    }

    public void editContract(){
        displayContract();
        System.out.print("Enter id contract (id booking) you want to edit: ");
        Integer checkIdContract = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < contractList.size(); i++) {
            if(contractList.get(i).getIdBooking().equals(checkIdContract)){
                System.out.print("Edit Money Deposit: ");
                Double moneyDepositEdit = Double.parseDouble(scanner.nextLine());
                contractList.get(i).setMoneyDeposit(moneyDepositEdit);
                System.out.print("Edit start date: ");
                Integer startDateEdit = Integer.parseInt(scanner.nextLine());
                contractList.get(i).setStartDate(startDateEdit);
                System.out.print("Edit end date: ");
                Integer endDateEdit = Integer.parseInt(scanner.nextLine());
                contractList.get(i).setEndDate(endDateEdit);
            }
        }
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

        bookingList.add(new Booking(idBooking++,customerInformation,facilityInformation,startDate,endDate));
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
