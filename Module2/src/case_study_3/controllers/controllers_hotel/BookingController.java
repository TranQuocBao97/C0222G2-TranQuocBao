package case_study_3.controllers.controllers_hotel;

import java.util.Scanner;

public class BookingController {
    static Scanner scanner = new Scanner(System.in);
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

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:
                        return;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter your right number on menu.");
            }
        }
    }
}
