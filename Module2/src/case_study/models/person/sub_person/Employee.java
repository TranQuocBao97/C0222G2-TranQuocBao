package case_study.models.person.sub_person;

import case_study.models.person.AbsPerson;

public class Employee extends AbsPerson {
    private String job;
    private Integer idEmployee;
    private Integer salary;

    public Employee(){

    }

    public Employee(String job, Integer idEmployee, Integer salary) {
        this.job = job;
        this.idEmployee = idEmployee;
        this.salary = salary;
    }

    public Employee(String name, Integer ege, String gender, Integer idCitizen,String phoneNumber, String job, Integer idEmployee, Integer salary) {
        super(name, ege, gender, idCitizen, phoneNumber);
        this.job = job;
        this.idEmployee = idEmployee;
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", job: " + job +
                ", idEmployee: " + idEmployee +
                ", salary: " + salary;
    }
}
