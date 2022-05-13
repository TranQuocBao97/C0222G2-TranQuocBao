package case_study_2.services.class_implement.person_implement;

import case_study.services.ICustomerService;
import case_study_2.models.person.sub_person.Customer;
import case_study_2.utils.ReadFile;
import case_study_2.utils.WriteFile;
import case_study_2.utils.take_data_input_by_condition.BirthdayOver18Under100;
import case_study_2.utils.select_property_value.CustomerLevel;
import case_study_2.utils.take_data_input_by_condition.BirthdayOver18Under100Ver2;

import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    static Scanner scanner = new Scanner(System.in);
    private static final String FILE_DATA_CUSTOMER = "src/case_study_2/data/File_Data_Customer.csv";
    private static final List<Customer> customerList;
    static {
        customerList = ReadFile.customerListFromFileData(FILE_DATA_CUSTOMER);
    }

    public static String selectIdCustomer(){
        while (true){
            String idCustomer = null;
            try{
                int stt = 0;
                for (Customer customer : customerList) {
                    System.out.println("STT. " + (++stt) + ": "  +customer);
                }

                System.out.print("Select STT to get id customer: ");
                int select = Integer.parseInt(scanner.nextLine());
                int checkSelect = 1;
                for(Customer customer : customerList){
                    if(select==checkSelect){
                        return customer.getIdCustomer();
                    }
                    checkSelect++;
                }
                if(idCustomer==null){
                    throw new Exception();
                }
            }catch (Exception e){
                System.out.print("please pick right number");
            }
        }
    }

    @Override
    public void add() {
        System.out.print("Add name: ");
        String name = scanner.nextLine();

        String birth = BirthdayOver18Under100Ver2.takeBirthdayAvailable();
        System.out.print("Add gender: ");
        String gender = scanner.nextLine();
        System.out.print("Add id citizen: ");
        String idCitizen = scanner.nextLine();
        System.out.print("Add phoneNumber: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Add email: ");
        String email = scanner.nextLine();
        System.out.print("Add id Customer: ");
        String idCustomer = scanner.nextLine();

        String customerLevel = CustomerLevel.selectCustomerLevel();
        customerList.add(new Customer(name,birth,gender,idCitizen,phoneNumber,email,idCustomer,customerLevel));
        WriteFile.writeCustomerListToCsv(FILE_DATA_CUSTOMER,customerList,false);
    }

    @Override
    public void display() {
        int stt = 0;
        for (Customer customer : customerList) {
            System.out.println("STT. " + (++stt) + ": "  +customer);
        }

    }

    @Override
    public void edit() {
        display();
        System.out.print("Select STT to Edit Customer: ");
        int checkStt = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < customerList.size(); i++) {
            if (checkStt == i + 1) {
                System.out.print("Edit name: ");
                String name = scanner.nextLine();

                System.out.print("Add birth: ");
                String birth = BirthdayOver18Under100Ver2.takeBirthdayAvailable();


                System.out.print("Edit gender");
                String gender = scanner.nextLine();
                System.out.print("Edit id citizen: ");
                String idCitizen = scanner.nextLine();
                System.out.print("Edit phoneNumber: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Edit email: ");
                String email = scanner.nextLine();

                System.out.print("Add id Customer: ");
                String idCustomer = scanner.nextLine();

                String customerLevel = CustomerLevel.selectCustomerLevel();

                customerList.get(i).setName(name);
                customerList.get(i).setBirth(birth);
                customerList.get(i).setGender(gender);
                customerList.get(i).setIdCitizen(idCitizen);
                customerList.get(i).setPhoneNumber(phoneNumber);
                customerList.get(i).setEmail(email);
                customerList.get(i).setIdCustomer(idCustomer);
                customerList.get(i).setCustomerLevel(customerLevel);

            }
        }
    }
}
