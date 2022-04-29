package case_study_2.controllers.controllers_furama;



import case_study_2.controllers.FuramaController;
import case_study_2.services.IService;
import case_study_2.services.class_implement.facility_implement.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityController {
    static Scanner scanner = new Scanner(System.in);
    static IService facilityService = new FacilityServiceImpl();
    public static void facilityMenu(){
        while (true){
            System.out.println("-------Facility Menu-------");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            System.out.print("Enter your function: ");
            int pickFacilityMenu = Integer.parseInt(scanner.nextLine());
            switch (pickFacilityMenu){
                case 1:
                    facilityService.display();
                    break;
                case 2:
                    facilityService.add();
                    break;
                case 3:
                    ((FacilityServiceImpl) facilityService).displayMaintenance();
                    break;
                case 4:
                    FuramaController.displayMainMenu();
                    break;
                default:
                    System.out.println("Please enter your right number on menu.");
            }
        }
    }
}
