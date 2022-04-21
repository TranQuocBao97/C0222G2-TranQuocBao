package case_study.controllers.managementController;

import case_study.controllers.FuramaController;
import case_study.services.implement.booking.BookingServiceImpl;

import java.util.Scanner;

public class BookingController {
    static Scanner scanner = new Scanner(System.in);
    private static BookingServiceImpl bookingService = new BookingServiceImpl();
    public static void bookingMenu(){
        while (true){
            System.out.println("-------Booking Menu-------");
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new contracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            System.out.println("Enter your function: ");
            int pickBooking = Integer.parseInt(scanner.nextLine());
            switch (pickBooking){
                case 1:
                    bookingService.add();
                    break;
                case 2:
                    bookingService.display();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    FuramaController.displayMainMenu();
                    break;
                default:
                    System.out.println("Please enter your right number on menu.");
            }
        }
    }
}
