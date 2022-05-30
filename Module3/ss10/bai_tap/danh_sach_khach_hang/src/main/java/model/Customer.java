package model;

import java.util.Date;

public class Customer {
    public String name;
    public String birthday;
    public String address;
    public String picUrl;

    public Customer() {
    }

    public Customer(String name, String birthday, String address, String picUrl) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.picUrl = picUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
