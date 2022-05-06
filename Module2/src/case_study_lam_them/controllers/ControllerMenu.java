package case_study_lam_them.controllers;

import case_study_lam_them.controllers.each_controller.StudentController;
import case_study_lam_them.controllers.each_controller.TeacherController;

import java.util.Scanner;

public class ControllerMenu {
    static Scanner scanner = new Scanner(System.in);
    public static void displayMenu(){
        while (true){
            try{
                System.out.println("-----Menu Controller-----");
                System.out.println("1. Student");
                System.out.println("2. Teacher");
                System.out.println("3. Exit");
                System.out.print("Select: ");
                int select = Integer.parseInt(scanner.nextLine());
                switch (select){
                    case 1:
                        StudentController.displayStudentController();
                        break;
                    case 2:
                        TeacherController.displayTeacherController();
                        break;
                    case 3:
                        System.exit(0);
                }
            }catch (Exception e){
                System.out.println("Enter right number on menu please");
            }
        }

    }
}
