package test.student_manager_compare.controller;

import test.student_manager_compare.model.Student;
import test.student_manager_compare.service.impl.StudentServiceImpl;

import java.util.Scanner;
public class MainController {
    public static void displayMainMenu() {
        // Khởi tạo đối tượng để quản lý sinh viên
        StudentServiceImpl studentManager = new StudentServiceImpl();
        Scanner scanner=new Scanner(System.in);
        boolean flag=true;
        do {
            System.out.println("Main menu\n" +
                    "1. Display\n" +
                    "2.Add\n" +
                    "3.Update\n" +
                    "4.Delete\n" +
                    "5.Search\n" +
                    "6. Change school name for all student"+
                    "7. Exit");
            System.out.println("Hạy chọn chức năng");
            int chooseMenue = Integer.parseInt(scanner.nextLine());
            switch (chooseMenue){
                case 1:
                    // code hiện thị
                    System.out.println("Danh sách sinh viên");
                     studentManager.display();
                    break;
                case 2:
                    System.out.println("thêm mới");
                    studentManager.add();
                    // code thêm mới
                    break;
                case 3:
                    System.out.println("chỉnh sửa");
                    // code hiện thị
                    break;
                case 4:
                    System.out.println("Xóa");
                    // code hiện thị
                    break;
                case 5:
                    System.out.println("Tìm kiếm");
                    // code hiện thị
                    break;
                case 6:
                    System.out.println("Thay đổi tên trường cho tất cả sinh viên");
                    Student.school =scanner.nextLine();
                    break;
                default:
                    System.out.println("Đa thoát");
                    flag=false;
                    // code hiện thị
                    break;
            }
        }while (flag);

    }
}
