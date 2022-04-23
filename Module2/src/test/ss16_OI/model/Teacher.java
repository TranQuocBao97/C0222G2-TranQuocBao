package test.ss16_OI.model;

import test.ss16_OI.model.Employee;

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

    @Override
    public String toString() {
        return "Teacher :"+ super.toString();
    }
    public String getInfoToCSV(){
        return this.getId()+","+this.getName()+
                ","+this.getAddress()+","+this.getSalary();
    }
}
