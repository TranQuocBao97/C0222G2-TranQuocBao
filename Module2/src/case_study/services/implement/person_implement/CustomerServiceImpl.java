package case_study.services.implement.person_implement;

import case_study.models.person.sub_person.Customer;
import case_study.models.person.sub_person.Employee;
import case_study.services.ICustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    static Scanner scanner = new Scanner(System.in);
    private static List<Customer> customerLinkedList = new LinkedList<>();
    static Integer idCustomer = 0;

    static {
        customerLinkedList.add(new Customer("Bảo", 18, "Nam", 212420254, "0168954485", ++idCustomer, "Diamond"));
        customerLinkedList.add(new Customer("Lực", 26, "Nam", 205475885, "0155486689", ++idCustomer, "platinum"));
        customerLinkedList.add(new Customer("Hiền", 22, "Nữ", 278445231, "0136558897", ++idCustomer, "Gold"));
        customerLinkedList.add(new Customer("Thảo", 25, "Nữ", 200458854, "0447889962", ++idCustomer, "Member"));
        customerLinkedList.add(new Customer("Hiền", 27, "Nữ", 158458202, "0355698665", ++idCustomer, "Member"));
        customerLinkedList.add(new Customer("Thảo", 22, "Nữ", 187554856, "2155896651", ++idCustomer, "Gold"));
        customerLinkedList.add(new Customer("Long", 29, "Nữ", 322155845, "0579665225", ++idCustomer, "Member"));
        customerLinkedList.add(new Customer("Lĩnh", 21, "Nữ", 122545586, "0322589655", ++idCustomer, "Member"));
        customerLinkedList.add(new Customer("Tôm", 24, "Nữ", 122256658, "0115488965", ++idCustomer, "platinum"));
        customerLinkedList.add(new Customer("Tép", 27, "Nữ", 105566898, "0322563569", ++idCustomer, "Diamond"));
    }

    public String select(Integer pick) {
        String customerInformation = null;
//        for (int i = 0; i < customerLinkedList.size(); i++) {
//            if(pick==i){
//                customerInformation = customerLinkedList.get(i).toString();
//            }
//        }
        for (Customer customer : customerLinkedList) {
            if (customer.getIdCustomer().equals(pick)) {
                customerInformation = customer.toString();
            }
        }
        return customerInformation;
    }

    @Override
    public void add() {
        System.out.print("Add Customer name: ");
        String name = scanner.nextLine();
        System.out.print("Add Customer age: ");
        Integer age = Integer.parseInt(scanner.nextLine());
        System.out.print("Add Customer gender: ");
        String gender = scanner.nextLine();
        System.out.print("Add id Citizen: ");
        Integer idCitizen = Integer.parseInt(scanner.nextLine());
        System.out.print("Add phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Add Customer Type: ");
        String typeCustomer = addCustomerType();
        customerLinkedList.add(new Customer(name, age, gender, idCitizen, phoneNumber, ++idCustomer, typeCustomer));
    }

    private String addCustomerType() {
        while (true) {
            System.out.println("-------Menu type customer------");
            System.out.println("1. Member");
            System.out.println("2. Silver");
            System.out.println("3. Gold");
            System.out.println("4. Platinum");
            System.out.println("5. Diamond");
            Integer pickType = Integer.parseInt(scanner.nextLine());
            switch (pickType) {
                case 1:
                    return "Member";
                case 2:
                    return "Silver";
                case 3:
                    return "Gold";
                case 4:
                    return "Platinum";
                case 5:
                    return "Diamond";
                case 6:
                    System.out.println("Please Enter right number to pick type custom");
            }
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < customerLinkedList.size(); i++) {
            System.out.println((i + 1) + ". " + customerLinkedList.get(i).toString());
        }
    }

    @Override
    public void edit() {
        System.out.print("Enter id customer for edit: ");
        Integer idEditCustomer = Integer.parseInt(scanner.nextLine());
        for (Customer customer : customerLinkedList) {
            if (customer.getIdCustomer().equals(idEditCustomer)) {
                System.out.println("found: (" + customer + ")");
                System.out.print("Edit name: ");
                String name = scanner.nextLine();
                System.out.print("Edit age: ");
                Integer age = Integer.parseInt(scanner.nextLine());
                System.out.print("Edit gender: ");
                String gender = scanner.nextLine();
                System.out.print("Edit id Citizen: ");
                Integer idCitizen = Integer.parseInt(scanner.nextLine());
                System.out.print("Edit phone number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Edit Customer Type: ");
                String typeCustomer = addCustomerType();
                customer.setName(name);
                customer.setEge(age);
                customer.setGender(gender);
                customer.setIdCitizen(idCitizen);
                customer.setPhoneNumber(phoneNumber);
                customer.setTypeCustomer(typeCustomer);
                display();
            }
        }
    }
}
