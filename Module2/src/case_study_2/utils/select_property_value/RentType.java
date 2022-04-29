package case_study_2.utils.select_property_value;

import java.util.Scanner;

public class RentType {
    private static Scanner scanner = new Scanner(System.in);
    public static String selectRent(){
        while (true){
            System.out.println("-------Select type rent-------");
            System.out.println("1. Năm.");
            System.out.println("2. Tháng.");
            System.out.println("3. Ngày.");
            System.out.println("4. Giờ.");
            System.out.println("Select type rent: ");
            try{
                int select = Integer.parseInt(scanner.nextLine());
                switch (select){
                    case 1:
                        return "Năm";
                    case 2:
                        return "Tháng";
                    case 3:
                        return "Ngày";
                    case 4:
                        return "Giờ";
                }
            }catch (Exception e){
                System.out.println("Please enter right number to select!");
            }
        }
    }
}
