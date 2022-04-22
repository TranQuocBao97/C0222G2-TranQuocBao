package case_study.models.person.sub_person;

import case_study.models.person.AbsPerson;

public class Customer extends AbsPerson {
    private Integer idCustomer;
    private String typeCustomer;


    public Customer(){

    }

    public Customer(Integer idCustomer, String typeCustomer) {
        this.idCustomer = idCustomer;
        this.typeCustomer = typeCustomer;
    }

    public Customer(String name, Integer ege, String gender, Integer idCitizen, String phoneNumber, Integer idCustomer, String typeCustomer) {
        super(name, ege, gender, idCitizen, phoneNumber);
        this.idCustomer = idCustomer;
        this.typeCustomer = typeCustomer;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", idCustomer: " + idCustomer +
                ", typeCustomer: " + typeCustomer;
    }
}
