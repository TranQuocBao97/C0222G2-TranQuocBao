package case_study_2.utils.select_property_value;

import java.util.Scanner;

public class CustomerLevel {
    private static Scanner scanner = new Scanner(System.in);
    public static String selectCustomerLevel(){
        while (true){
            System.out.println("-------Select Customer Level-------");
            System.out.println("1. Diamond.");
            System.out.println("2. Platinum.");
            System.out.println("3. Gold.");
            System.out.println("4. Silver.");
            System.out.println("5. Member.");
            System.out.println("Select Customer Level: ");
            try{
                int select = Integer.parseInt(scanner.nextLine());
                switch (select){
                    case 1:
                        return "Diamond";
                    case 2:
                        return "Platinum";
                    case 3:
                        return "Gold";
                    case 4:
                        return "Silver";
                    case 5:
                        return "Member";
                }
            }catch (Exception e){
                System.out.println("Please enter right number to select!");
            }
        }
    }
}
