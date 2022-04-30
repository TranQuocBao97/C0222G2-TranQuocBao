package case_study_2.controllers.controllers_furama;



import case_study_2.controllers.FuramaController;
import case_study_2.services.class_implement.person_implement.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerController {
    static Scanner scanner = new Scanner(System.in);
    static CustomerServiceImpl customerService = new CustomerServiceImpl();
    public static void customerMenu(){
        while (true){
            System.out.println("-------Customer Menu------");
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return main menu");
            System.out.println("Enter your function: ");
            int pickCustomerMenu = Integer.parseInt(scanner.nextLine());
            switch (pickCustomerMenu){
                case 1:
                    customerService.display();
                    break;
                case 2:
                    customerService.add();
                    break;
                case 3:
                    customerService.edit();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Please enter the right number on menu.");
            }
        }
    }
}
