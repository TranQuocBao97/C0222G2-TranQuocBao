package case_study.models.person;

public abstract class AbsPerson {
    private String name;
    private Integer ege;
    private String gender;

    public AbsPerson() {
    }

    public AbsPerson(String name, Integer ege, String gender) {
        this.name = name;
        this.ege = ege;
        this.gender = gender;
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

    @Override
    public String toString() {
        return "name: " + name +
                ", ege: " + ege +
                ", gender: " + gender;
    }
}
