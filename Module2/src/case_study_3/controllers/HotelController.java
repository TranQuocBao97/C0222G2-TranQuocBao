package case_study_3.controllers;

import case_study_2.controllers.controllers_furama.*;

import java.util.Scanner;

public class HotelController {
    static Scanner scanner = new Scanner(System.in);
    public static void displayMainMenu(){
        while (true) {
            System.out.println("-------Welcome To Hotel Main Menu-------");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            try {
                System.out.print("Enter your function: ");
                int pickMainMenu = Integer.parseInt(scanner.nextLine());
                switch (pickMainMenu) {
                    case 1:
                        EmployeeController.bookingMenu();
                        break;
                    case 2:
                        CustomerController.customerMenu();
                        break;
                    case 3:
                        FacilityController.facilityMenu();
                        break;
                    case 4:
                        BookingController.bookingMenu();
                        break;
                    case 5:
                        PromotionController.promotion();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please pick your right number on menu");
            }


        }
    }

}
