package case_study_lam_them_2.controllers.function_controllers;

import case_study_lam_them.services.IService;
import case_study_lam_them.services.class_implement.StudentService;
import case_study_lam_them.services.class_implement.TeacherService;
import case_study_lam_them_2.utils.get_input_number_with_exception.IntegerInputTest;

import java.util.Scanner;

public class AddControllerMenu {
    static Scanner scanner = new Scanner(System.in);
    public static void showAddMenu(){
        IService iService;
        System.out.println("Select Add menu");
        System.out.println("1. add student");
        System.out.println("2. add teacher");
        System.out.print("Select: ");
        while (true){
            Integer select = IntegerInputTest.checkIntegerInput();
            switch (select){
                case 1:
                    iService = new StudentService();
                    iService.add();
                    break;
                case 2:
                    iService = new TeacherService();
                    iService.add();
                    break;
                default:
                    System.out.print("Please Enter right number to select, try again: ");
            }
        }


    }
}
