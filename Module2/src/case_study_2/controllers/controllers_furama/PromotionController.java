package case_study_2.controllers.controllers_furama;



import case_study_2.controllers.FuramaController;

import java.util.Scanner;

public class PromotionController {
    static Scanner scanner = new Scanner(System.in);
    public static void promotion(){
        while (true){
            System.out.println("-------Promotion Menu-------");
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            System.out.println("Enter your function: ");
            int pickPromotion = Integer.parseInt(scanner.nextLine());
            switch (pickPromotion){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    FuramaController.displayMainMenu();
                    break;
                default:
                    System.out.println("Please enter your right number on menu.");
            }
        }


    }
}
