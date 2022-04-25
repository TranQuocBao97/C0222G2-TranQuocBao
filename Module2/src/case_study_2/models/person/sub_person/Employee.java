package case_study_2.models.person.sub_person;

import case_study_2.models.person.Person;

public class Employee extends Person {
    private Integer idEmployee;
    private String job;
    private String educationLevel;
    private Double salary;

    public Employee(Integer idEmployee, String job, String educationLevel, Double salary) {
        this.idEmployee = idEmployee;
        this.job = job;
        this.educationLevel = educationLevel;
        this.salary = salary;
    }

    public Employee(String name, String birth, String gender, String idCitizen, String phoneNumber, String email,
                    Integer idEmployee, String job, String educationLevel, Double salary) {
        super(name, birth, gender, idCitizen, phoneNumber, email);
        this.idEmployee = idEmployee;
        this.job = job;
        this.educationLevel = educationLevel;
        this.salary = salary;
    }

    public String propertiesToCsv(){
        return getName()+","+getBirth()+","+getGender()+","+getIdCitizen()+","+getPhoneNumber()+","+getEmail()+
                ","+idEmployee+","+job+","+educationLevel+","+salary;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "idEmployee: " + idEmployee +
                ", job: " + job +
                ", educationLevel: " + educationLevel +
                ", salary: "  + String.format ("%.0f",salary) + "(VND)"+
                super.toString();
    }
}
