package ss4_class_object.student_manager1.model;

import ss4_class_object.student_manager1.model.Person;

public class Employee extends Person {
    int Salary;
    public Employee(){

    }
    public Employee(int salary) {
        Salary = salary;
    }

    public Employee(int id, String name, String address, int salary) {
        super(id, name, address);
        Salary = salary;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
}
