package test.ss16_OI.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        HashSet<Student> studentHashSet = new HashSet<>();
        studentHashSet.add(new Student(1,"chanh1","DN",5));
        studentHashSet.add(new Student(2,"chanh1","DN",3));
        studentHashSet.add(new Student(3,"chanh1","DN",3));
        studentHashSet.add(new Student(4,"chanh1","DN",3));
        studentHashSet.add(new Student(5,"chanh1","DN",3));
        studentHashSet.add(new Student(1,"chanh1","DN1",32));
        for (Student s: studentHashSet) {
            System.out.println((s.hashCode()+": "+s));
        }
    }
}
