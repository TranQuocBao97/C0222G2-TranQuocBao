package test.student_manager_compare.model;

import test.student_manager_compare.model.Person;

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
