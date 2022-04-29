package case_study_2.utils.select_property_value;

import java.util.Scanner;

public class EducationLevel {
    private static Scanner scanner = new Scanner(System.in);
    public static String selectEducationLevel(){
        while (true){
            System.out.println("-------Select education level-------");
            System.out.println("1. Trung cấp.");
            System.out.println("2. Cao đẳng.");
            System.out.println("3. Đại học .");
            System.out.println("4. Sau đại học.");
            System.out.println("Select education level: ");
            try{
                int select = Integer.parseInt(scanner.nextLine());
                switch (select){
                    case 1:
                        return "Trung cấp";
                    case 2:
                        return "Cao đẳng";
                    case 3:
                        return "Đại học";
                    case 4:
                        return "Sau đại học";
                }
            }catch (Exception e){
                System.out.println("Please enter right number to select!");
            }
        }
    }
}
