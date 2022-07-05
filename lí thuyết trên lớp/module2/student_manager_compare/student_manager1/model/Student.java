package ss4_class_object.student_manager1.model;

import ss4_class_object.student_manager1.model.Person;

public class Student extends Person implements Comparable<Student>  {
    public int point;
    public static String school = "BK";
    public Student() {

    }
    public Student(int id, String name, String address, int point) {
        super(id, name, address);
        this.point = point;
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

    @Override
    public int compareTo(Student student) {
        // nếu 0: thì bằng nhau
        // nếu <0; nhỏ hơn
        // nếu >0 thì lớn hơn
       return student.point-this.point;
    }
}
