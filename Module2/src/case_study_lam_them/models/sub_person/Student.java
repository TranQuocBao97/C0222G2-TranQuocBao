package case_study_lam_them.models.sub_person;

import case_study_lam_them.models.Person;

public class Student extends Person {
    private String className;
    private Integer mark;

    public Student(String className, Integer mark) {
        this.className = className;
        this.mark = mark;
    }

    public Student(String id, String name, String birthday, String gender, String className, Integer mark) {
        super(id, name, birthday, gender);
        this.className = className;
        this.mark = mark;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "className='" + className + '\'' +
                ", mark='" + mark + '\'' +
                "} " + super.toString();
    }

    public String toStringForCsv(){
        return getId()+","+getName()+","+getBirthday()+","+getGender()+","+className+","+mark;
    }
}
