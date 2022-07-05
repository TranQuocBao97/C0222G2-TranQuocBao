package model;

public class Customer {
    private int id;
    private String name;
    private int gender;
    private String birthday;

    private int customerTypeId ;

    public Customer(String name, int gender, String birthday, int customerTypeId) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.customerTypeId = customerTypeId;
    }

    public Customer() {
    }

    public Customer(int id, String name, int gender, String birthday, int customerTypeId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.customerTypeId = customerTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }
}
