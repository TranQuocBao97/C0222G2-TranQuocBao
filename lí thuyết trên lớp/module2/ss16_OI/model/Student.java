package ss4_class_object.student_manager1.model;

import ss4_class_object.student_manager1.model.Person;

import java.util.Objects;

public class Student extends Person {
    public int point;
    public static String school = "BK";

    public Student() {

    }
    public Student(int id, String name, String address, int point) {
        super(id, name, address);
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public static String getSchool() {
        return school;
    }

    public static void setSchool(String school) {
        Student.school = school;
    }

    // method hiện thị thông tin đối tượng dạng chuỗi
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", point=" + point +
                ", school='" + school + '\'' +
                '}';
    }
    public String getInfoToCSV(){
        return this.getId()+","+this.getName()+
                ","+this.getAddress()+","+this.getPoint();
    }
}
