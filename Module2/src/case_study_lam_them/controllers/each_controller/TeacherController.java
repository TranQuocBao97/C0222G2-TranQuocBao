package case_study_lam_them.controllers.each_controller;


import case_study_lam_them.models.sub_person.Teacher;
import case_study_lam_them.services.IService;
import case_study_lam_them.services.class_implement.TeacherService;

import java.util.Scanner;

public class TeacherController {
    static Scanner scanner = new Scanner(System.in);
    private static final IService<Teacher> iService = new TeacherService();
    public static void displayTeacherController(){
        while (true){
            System.out.println("-----Teacher Menu-----");
            System.out.println("1. Add teacher");
            System.out.println("2. Delete teacher");
            System.out.println("3. Display teacher");
            System.out.println("4. Search teacher");
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
