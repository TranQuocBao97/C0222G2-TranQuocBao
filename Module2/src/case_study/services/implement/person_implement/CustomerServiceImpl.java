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
    static {
        customerLinkedList.add(new Customer("Bảo",18,"Nam",212420254));
        customerLinkedList.add(new Customer("Lực",26,"Nam",205475885));
        customerLinkedList.add(new Customer("Hiền",22,"Nữ",278445231));
        customerLinkedList.add(new Customer("Thảo",25,"Nữ",200458854));
    }

    public String select(Integer pick){
        String customerInformation = null;
//        for (int i = 0; i < customerLinkedList.size(); i++) {
//            if(pick==i){
//                customerInformation = customerLinkedList.get(i).toString();
//            }
//        }
        for(Customer customer: customerLinkedList){
            if(customer.getIdCitizen().equals(pick)){
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
        customerLinkedList.add(new Customer(name,age,gender,idCitizen));
    }

    @Override
    public void display() {
        for (int i = 0; i < customerLinkedList.size(); i++) {
            System.out.println((i+1)+". "+customerLinkedList.get(i).toString());
        }
    }

    @Override
    public void edit() {
        System.out.println("Enter id citizen customer for edit: ");
        Integer idEditCustomer = Integer.parseInt(scanner.nextLine());
        for(Customer customer: customerLinkedList){
            if(customer.getIdCitizen().equals(idEditCustomer)){
                while(true) {
                    System.out.println("found: ("+customer+")");
                    System.out.print("Edit name: ");
                    String name = scanner.nextLine();
                    System.out.print("Edit age: ");
                    Integer age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Edit gender: ");
                    String gender = scanner.nextLine();
                    if(name.equals("") || age.equals(0) || gender.equals("")){
                        System.out.println("Please Enter Full information");
                    }else {
                        customer.setName(name);
                        customer.setEge(age);
                        customer.setGender(gender);
                        display();
                    }
                }
            }
        }
    }
}
