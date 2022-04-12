package test.demo_list_student;

import java.util.Scanner;

public class MainDemo {
    public static void main(String[] args) {
        StudentsManager studentsManager = new StudentsManager();
        Scanner input = new Scanner(System.in);
        studentsManager.availableStudent();
        boolean flag0 = true;
        do {
            System.out.println("Menu function: ");
            System.out.println("1. Display");
            System.out.println("2. Add");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Search");
            System.out.println("6. Exit");
            System.out.print("Your pick: ");
            int pickMenu = Integer.parseInt(input.nextLine());
            switch (pickMenu){
                case 1:
                    System.out.println("List of students: ");
                    studentsManager.display();
                    break;
                case 2:
                    System.out.println("Add student to the list");
                    studentsManager.add();
                    break;
                case 3:
                    System.out.println("Update");
                    studentsManager.update();
                    break;
                case 4:
                    System.out.println("Delete");
                    studentsManager.delete();
                    break;
                case 5:
                    System.out.println("Search");
                    studentsManager.search();
                    break;
                case 6:
                    System.out.println("Exit");
                    flag0 = false;
                    break;
            }
        }while (flag0);
    }
}
