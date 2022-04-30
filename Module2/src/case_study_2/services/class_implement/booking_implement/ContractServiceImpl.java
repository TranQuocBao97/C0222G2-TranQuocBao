package case_study_2.services.class_implement.booking_implement;

import case_study_2.models.Booking;
import case_study_2.models.Contract;
import case_study_2.services.IContractService;
import case_study_2.services.class_implement.facility_implement.FacilityServiceImpl;
import case_study_2.utils.ReadFile;
import case_study_2.utils.WriteFile;
import case_study_2.utils.compareTime.DateString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContractServiceImpl implements IContractService {
    private static final String FILE_DATA_CONTRACT = "src/case_study_2/data/File_Data_Contract.csv";
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Contract> contractList = new ArrayList<>();
    private static BookingServiceImpl bookingService = new BookingServiceImpl();
    static {
        contractList = ReadFile.contractListFromFileDate(FILE_DATA_CONTRACT);
    }


    @Override
    public void add() {
        BookingServiceImpl.displayBookingQueueList();
        while (true) {
            Booking booking = null;
            System.out.print("Add id contract: ");
            String idContract = scanner.nextLine();
            System.out.println("Select Yes to get first Booking on list");
            System.out.println("1. Yes");
            System.out.println("2. Return booking menu");
            System.out.print("Select: ");
            try {
                int select = Integer.parseInt(scanner.nextLine());
                switch (select) {
                    case 1:
                        booking = bookingService.addToContractList();
                        String bookingInformation = booking.getIdFacility();
                        Integer dayUseService =  DateString.swapToIntegerDay(booking.getDayEnd()) - DateString.swapToIntegerDay(booking.getDayStart());
                        Double pricePerDay = FacilityServiceImpl.checkPricePerDay(booking.getIdFacility());
                        Double depositMoney = (pricePerDay*dayUseService)/2;
                        Double totalMoney = pricePerDay*dayUseService;

                        contractList.add(new Contract(idContract,bookingInformation,depositMoney,totalMoney));
                        WriteFile.writeContractListToCsv(FILE_DATA_CONTRACT,contractList,false);
                    case 2:
                        return;
                }
            } catch (Exception e) {
                System.out.println("You need enter the right thing on menu, do it again!");
            }
        }
    }

    @Override
    public void display() {
        int stt = 0;
        for (Contract contract : contractList){
            System.out.println("STT."+(++stt)+": "+contract);
        }
    }


    @Override
    public void edit() {
        display();
        Contract contractEdit = null;
        while (true){
            try{
                System.out.println("Select by STT to Edit:");
                int select = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < contractList.size(); i++) {
                    if(select == i+1){
                        contractEdit = contractList.get(i);
                        break;
                    }
                }
                System.out.print("Edit id: ");
                contractEdit.setIdContract(scanner.nextLine());
                System.out.print("Edit deposit money: ");
                contractEdit.setDepositMoney(Double.parseDouble(scanner.nextLine()));
                System.out.print("Edit total money");
                contractEdit.setTotalMoney(Double.parseDouble(scanner.nextLine()));
            }catch (Exception e){
                System.out.println("You Enter Some Wrong Data");
            }
        }



    }
}
