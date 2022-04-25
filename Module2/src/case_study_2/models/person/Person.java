package case_study_2.models.person;

public class Person {
    private String name;
    private String birth;
    private String gender;
    private String idCitizen;
    private String phoneNumber;
    private String email;

    public Person() {
    }

    public Person(String name, String birth, String gender, String idCitizen, String phoneNumber, String email) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.idCitizen = idCitizen;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(String idCitizen) {
        this.idCitizen = idCitizen;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return ", name: " + name +
                ", birth: " + birth +
                ", gender: " + gender +
                ", idCitizen: " + idCitizen +
                ", phoneNumber: " + phoneNumber +
                ", email: " + email +". ";
    }
}
