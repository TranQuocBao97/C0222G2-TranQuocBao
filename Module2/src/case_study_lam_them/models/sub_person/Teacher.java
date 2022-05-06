package case_study_lam_them.models.sub_person;

import case_study_lam_them.models.Person;

public class Teacher extends Person {
    private String expertise;

    public Teacher(String expertise) {
        this.expertise = expertise;
    }

    public Teacher(String id, String name, String birthday, String gender, String expertise) {
        super(id, name, birthday, gender);
        this.expertise = expertise;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "expertise='" + expertise + '\'' +
                "} " + super.toString();
    }

    public String toStringForCsv(){
        return getId()+","+getName()+","+getBirthday()+","+getGender()+","+expertise;
    }
}
