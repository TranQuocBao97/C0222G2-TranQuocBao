package case_study_2.models.person.sub_person;

import case_study_2.models.person.Person;

public class Customer extends Person {
    private String idCustomer;
    private String customerLevel;

    public Customer(String idCustomer, String customerLevel) {
        this.idCustomer = idCustomer;
        this.customerLevel = customerLevel;
    }

    public Customer(String name, String birth, String gender, String idCitizen, String phoneNumber, String email, String idCustomer, String customerLevel) {
        super(name, birth, gender, idCitizen, phoneNumber, email);
        this.idCustomer = idCustomer;
        this.customerLevel = customerLevel;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel;
    }

    @Override
    public String toString() {
        return super.toString()+
                "idCustomer: " + idCustomer +
                ", customerLevel: " + customerLevel;
    }

    public String propertiesToCsv(){
        return getName()+","+getBirth()+","+getGender()+","+getIdCitizen()+","+getPhoneNumber()+","+getEmail()+
                ","+idCustomer+","+customerLevel;
    }
}
