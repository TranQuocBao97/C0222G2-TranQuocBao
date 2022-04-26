package case_study_2.controllers.controllers_furama;



import case_study_2.controllers.FuramaController;
import case_study_2.services.IEmployeeService;
import case_study_2.services.IService;
import case_study_2.services.class_implement.person_implement.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeController {
    static Scanner scanner = new Scanner(System.in);
    static IService employeeService = new EmployeeServiceImpl();
    public static void bookingMenu(){
        while (true){
            System.out.println("-------Employee Menu-------");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu");
            try{
                System.out.print("Enter your function: ");
                int pickBookingMenu = Integer.parseInt(scanner.nextLine());
                switch (pickBookingMenu){
                    case 1:
                        employeeService.display();
                        break;
                    case 2:
                        employeeService.add();
                        break;
                    case 3:
                        employeeService.edit();
                        break;
                    case 4:
                        FuramaController.displayMainMenu();
                        break;
                    default:
                        throw new Exception();
                }
            }catch (Exception e){
                System.out.println("Please enter the right number on menu.");
            }
        }

    }
}
