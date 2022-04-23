package test.ss16_OI.model;

import test.ss16_OI.model.Person;

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

    @Override
    public String toString() {
        return "Employee{" +
                "Salary=" + Salary +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
