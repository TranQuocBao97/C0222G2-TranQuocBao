package test.ss16_OI.service.impl;

import test.ss16_OI.model.Student;
import test.ss16_OI.model.Teacher;
import test.ss16_OI.service.StudentService;
import test.ss16_OI.util.WriteAndRead;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
// class để quan lý sinh viên
public class StudentServiceImpl implements StudentService {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void add(){
        System.out.println("nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tên sinh viên");
        String name = scanner.nextLine();
        System.out.println("nhập địa chỉ sinh viên");
        String address = scanner.nextLine();
        System.out.println("nhập điểm sinh viên");
        int point = Integer.parseInt(scanner.nextLine());
        // tạo 1 đối tượng mới

        Student student = new Student(id,name,address,point);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
//        WriteAndRead.writeStudentToCSV(studentList,true);
        WriteAndRead.writeStudentToCSV1(studentList,true);
    }
    // hiện thị thông tin của sinh viên
    @Override
    public void display() {
        List<Student> studentList = WriteAndRead.readFileCsvToListStudent1();
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i + 1) + "." + studentList.get(i).toString());
        }
    }
    @Override
    public void delete() {
        List<Student> studentList = WriteAndRead.readFileCsvToListStudent1();
        display();
        System.out.println("chọn student muốn xóa");
        int chooseDelete = Integer.parseInt(scanner.nextLine());
        studentList.remove(chooseDelete-1);
        WriteAndRead.writeStudentToCSV1(studentList,false);
    }

    @Override
    public void update() {

    }

    @Override
    public void searchByName() {

    }
}
