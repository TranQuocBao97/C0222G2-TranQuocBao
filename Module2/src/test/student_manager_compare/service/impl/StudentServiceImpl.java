package test.student_manager_compare.service.impl;

import test.student_manager_compare.common.CompByNameStudent;
import test.student_manager_compare.model.Student;
import test.student_manager_compare.service.StudentService;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
// class để quan lý sinh viên
public class StudentServiceImpl implements StudentService {
    static Student[] studentList = new Student[5];
    Scanner scanner = new Scanner(System.in);
    static {
        // khối static dùng để thay đổi/khởi tạo giá trị cho biến static.
        System.out.println("khối static chạy để khởi tạo giá trị ban đầu cho mảng");
        studentList[0]= new Student(1,"chánh5","DN",3);
        studentList[1]= new Student(2,"chánh2","DN",6);
        studentList[2]= new Student(3,"chánh3","DN",2);
        studentList[3]= new Student(4,"chánh4","DN",10);
        studentList[4]= new Student(5,"chánh1","DN",3);
    }
    // các hàm chức năng dùng quản lý Student + CRUD:
    // thêm mới sinh viên
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
        // đọc ghi file
        Student student = new Student(id,name,address,point);
        for (int i = 0; i < studentList.length ; i++) {
            if (studentList[i]==null){
                studentList[i]=student;
                break;
            }

        }
    }
    // hiện thị thông tin của sinh viên
    @Override
    public void display(){

        // sắp xếp điểm trước khi hiện thị
        Arrays.sort(studentList);
        for (int i = 0; i < studentList.length ; i++) {
            // kiểm trả null thì thì thêm vào vị trí null đầu tiên
            if (studentList[i]!=null){
                System.out.println((i+1) +"."+ studentList[i].toString());
            }else {
                // thoát for để chỉ thêm 1 đối tượng
                // không có break thì sẽ thêm vào tất cả phần tử phía sau => sai
                break;
            }

        }
        Arrays.sort(studentList,new CompByNameStudent());
        // hiện thi sắp xxeepstheo tên
        for (int i = 0; i < studentList.length ; i++) {
            // kiểm trả null thì thì thêm vào vị trí null đầu tiên
            if (studentList[i]!=null){
                System.out.println((i+1) +"."+ studentList[i].toString());
            }else {
                // thoát for để chỉ thêm 1 đối tượng
                // không có break thì sẽ thêm vào tất cả phần tử phía sau => sai
                break;
            }

        }
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        };
        // sor theo id;
        Arrays.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId()-o2.getId();
            }
        });
        for (int i = 0; i < studentList.length ; i++) {
            // kiểm trả null thì thì thêm vào vị trí null đầu tiên
            if (studentList[i]!=null){
                System.out.println((i+1) +"."+ studentList[i].toString());
            }else {
                // thoát for để chỉ thêm 1 đối tượng
                // không có break thì sẽ thêm vào tất cả phần tử phía sau => sai
                break;
            }

        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void searchByName() {

    }
}
