package case_study_2.controllers.controllers_furama;



import case_study_2.controllers.FuramaController;
import case_study_2.services.class_implement.Promo.PromotionServiceImpl;

import java.util.Scanner;

public class PromotionController {
    static Scanner scanner = new Scanner(System.in);
    private static PromotionServiceImpl promotionService = new PromotionServiceImpl();
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
                    promotionService.displayCustomerCurrentMonth();
                    break;
                case 2:
                    promotionService.displayCustomerGetVoucher();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Please enter your right number on menu.");
            }
        }
    }
}
