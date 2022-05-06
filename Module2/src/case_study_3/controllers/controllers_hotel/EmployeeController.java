package case_study_3.controllers.controllers_hotel;

import java.util.Scanner;

public class EmployeeController {
    static Scanner scanner = new Scanner(System.in);
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

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:
                        return;
                    default:
                        throw new Exception();
                }
            }catch (Exception e){
                System.out.println("Please enter the right number on menu.");
            }
        }

    }
}
