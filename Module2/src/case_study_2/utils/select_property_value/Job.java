package case_study_2.utils.select_property_value;

import java.util.Scanner;

public class Job {
    private static Scanner scanner = new Scanner(System.in);
    public static String selectJob(){
        while (true){
            System.out.println("-------Select Job-------");
            System.out.println("1. Lễ tân.");
            System.out.println("2. Phục vụ.");
            System.out.println("3. Chuyên viên.");
            System.out.println("4. Giám sát.");
            System.out.println("5. Quản lý.");
            System.out.println("6. Giám đốc");
            System.out.println("Select Job: ");
            try{
                int select = Integer.parseInt(scanner.nextLine());
                switch (select){
                    case 1:
                        return "Lễ tân";
                    case 2:
                        return "Phục vụ";
                    case 3:
                        return "Chuyên viên";
                    case 4:
                        return "Giám sát";
                    case 5:
                        return "Quản lý";
                    case 6:
                        return "Giám đốc";
                }
            }catch (Exception e){
                System.out.println("Please enter right number to select!");
            }
        }
    }
}
