package case_study_3.controllers.controllers_hotel;

import case_study_2.services.class_implement.facility_implement.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityController {
    static Scanner scanner = new Scanner(System.in);
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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    return;
                default:
                    System.out.println("Please enter your right number on menu.");
            }
        }
    }
}