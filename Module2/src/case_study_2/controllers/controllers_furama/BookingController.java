package case_study_2.controllers.controllers_furama;


import case_study_2.controllers.FuramaController;
import case_study_2.services.class_implement.booking_implement.BookingServiceImpl;
import case_study_2.services.class_implement.booking_implement.ContractServiceImpl;

import java.util.Scanner;

public class BookingController {
    static Scanner scanner = new Scanner(System.in);
    private static BookingServiceImpl bookingService = new BookingServiceImpl();
    private static ContractServiceImpl contractService = new ContractServiceImpl();

    public static void bookingMenu() {
        while (true) {
            System.out.println("-------Booking Menu-------");
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new contracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            try {
                System.out.print("Enter your function: ");
                Integer pickBooking = Integer.parseInt(scanner.nextLine());
                switch (pickBooking) {
                    case 1:
                        bookingService.add();
                        break;
                    case 2:
                        bookingService.display();
                        break;
                    case 3:
                        contractService.add();
                        break;
                    case 4:
                        contractService.display();
                        break;
                    case 5:
                        contractService.edit();
                        break;
                    case 6:
                        FuramaController.displayMainMenu();
                        break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter your right number on menu.");
            }
        }
    }
}
