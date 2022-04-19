package case_study.controllers.managementController;

import case_study.controllers.FuramaController;
import case_study.services.IEmployeeService;
import case_study.services.implement.person_implement.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeController {
    static Scanner scanner = new Scanner(System.in);
    static IEmployeeService iEmployeeService = new EmployeeServiceImpl();
    public static void bookingMenu(){
        while (true){
            System.out.println("-------Booking Menu-------");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu");
            System.out.print("Enter your function: ");
            int pickBookingMenu = Integer.parseInt(scanner.nextLine());
            switch (pickBookingMenu){
                case 1:
                    iEmployeeService.display();
                    break;
                case 2:
                    iEmployeeService.add();
                    break;
                case 3:
                    iEmployeeService.edit();
                    break;
                case 4:
                    FuramaController.displayMainMenu();
                    break;
                default:
                    System.out.println("Please enter the right number on menu.");
            }
        }

    }
}
