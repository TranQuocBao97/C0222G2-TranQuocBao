package case_study.models.person;

public abstract class AbsPerson {
    private String name;
    private Integer ege;
    private String gender;
    private Integer idCitizen;
    private String phoneNumber;

    public AbsPerson() {
    }

    public AbsPerson(String name, Integer ege, String gender, Integer idCitizen, String phoneNumber) {
        this.name = name;
        this.ege = ege;
        this.gender = gender;
        this.idCitizen = idCitizen;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEge() {
        return ege;
    }

    public void setEge(Integer ege) {
        this.ege = ege;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(Integer idCitizen) {
        this.idCitizen = idCitizen;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", ege: " + ege +
                ", gender: " + gender +
                ", id citizen: " + idCitizen +
                ", phone number: " + phoneNumber;
    }
}
