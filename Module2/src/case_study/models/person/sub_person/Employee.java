package case_study.models.person.sub_person;

import case_study.models.person.AbsPerson;

public class Employee extends AbsPerson {
    private String job;
    private Integer idEmployee;

    public Employee(){

    }

    public Employee(String job, Integer idEmployee) {
        this.job = job;
        this.idEmployee = idEmployee;
    }

    public Employee(String name, Integer ege, String gender, String job, Integer idEmployee) {
        super(name, ege, gender);
        this.job = job;
        this.idEmployee = idEmployee;
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

    @Override
    public String toString() {
        return super.toString() +
                ", job: " + job +
                ", ID employee: " + idEmployee;
    }
}
