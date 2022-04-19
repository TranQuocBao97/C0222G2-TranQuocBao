package case_study.models.person.sub_person;

import case_study.models.person.AbsPerson;

public class Customer extends AbsPerson {
    private Integer idCitizen;

    public Customer(){

    }
    public Customer(Integer idCitizen) {
        this.idCitizen = idCitizen;
    }

    public Customer(String name, Integer ege, String gender, Integer idCitizen) {
        super(name, ege, gender);
        this.idCitizen = idCitizen;
    }

    public Integer getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(Integer idCitizen) {
        this.idCitizen = idCitizen;
    }



    @Override
    public String toString() {
        return super.toString()+
                ", idCitizen: " + idCitizen;
    }
}
