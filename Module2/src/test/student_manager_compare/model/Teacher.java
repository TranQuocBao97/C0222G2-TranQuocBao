package test.student_manager_compare.model;

import test.student_manager_compare.model.Employee;

public class Teacher extends Employee {
    public Teacher() {
    }

    public Teacher(int salary) {
        super(salary);
    }

    public Teacher(int id, String name, String address, int salary) {
        super(id, name, address, salary);
    }

    public void teach(String subject){
        System.out.println(subject);
    }
}
