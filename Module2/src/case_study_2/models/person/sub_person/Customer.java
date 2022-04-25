package case_study_2.models.person.sub_person;

import case_study_2.models.person.Person;

public class Customer extends Person {
    private String idCustomer;
    private String levelCustomer;

    public Customer(String idCustomer, String levelCustomer) {
        this.idCustomer = idCustomer;
        this.levelCustomer = levelCustomer;
    }

    public Customer(String name, String birth, String gender, String idCitizen, String phoneNumber, String email, String idCustomer, String levelCustomer) {
        super(name, birth, gender, idCitizen, phoneNumber, email);
        this.idCustomer = idCustomer;
        this.levelCustomer = levelCustomer;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getLevelCustomer() {
        return levelCustomer;
    }

    public void setLevelCustomer(String levelCustomer) {
        this.levelCustomer = levelCustomer;
    }

    @Override
    public String toString() {
        return ", idCustomer: " + idCustomer +
                ", levelCustomer: " + levelCustomer +
                super.toString();
    }
}
