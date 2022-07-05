package ss4_class_object.student_manager1.common;

import ss4_class_object.student_manager1.model.Student;

import java.util.Comparator;

public class CompByNameStudent implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        // săp xếp theo tên
        return o1.getName().compareTo(o2.getName());
    }
}
