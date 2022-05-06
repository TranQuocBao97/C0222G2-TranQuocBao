package case_study_lam_them.controllers.each_controller;

import case_study_lam_them.models.sub_person.Student;
import case_study_lam_them.services.IService;
import case_study_lam_them.services.class_implement.StudentService;

import java.util.Scanner;

public class StudentController {
    static Scanner scanner = new Scanner(System.in);
    private static final IService<Student> iService = new StudentService();
    public static void displayStudentController(){
        while (true){
            System.out.println("-----Student Menu-----");
            System.out.println("1. Add student");
            System.out.println("2. Delete student");
            System.out.println("3. Display student");
            System.out.println("4. Search student");
            System.out.println("5. Return main menu");
            try{
                System.out.println("select: ");
                int select = Integer.parseInt(scanner.nextLine());
                switch (select){
                    case 1:
                        iService.add();
                        break;
                    case 2:
                        iService.delete();
                        break;
                    case 3:
                        iService.display();
                        break;
                    case 4:
                        iService.search();
                        break;
                    case 5:
                        return;
                }
            }catch (Exception e){
                System.out.println("Please select right number");
            }
        }
    }
}
