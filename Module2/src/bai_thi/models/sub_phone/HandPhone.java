package bai_thi.models.sub_phone;

import bai_thi.models.Phone;

public class HandPhone extends Phone {
    private String country;
    private String fixType;

    public HandPhone(String country, String fixType) {
        this.country = country;
        this.fixType = fixType;
    }

    public HandPhone(Integer id, String name, Integer price, Integer numberPhoneHave, String factory, String country, String fixType) {
        super(id, name, price, numberPhoneHave, factory);
        this.country = country;
        this.fixType = fixType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFixType() {
        return fixType;
    }

    public void setFixType(String fixType) {
        this.fixType = fixType;
    }

    @Override
    public String toString() {
        return "HandPhone{" +
                "country='" + country + '\'' +
                ", fixType='" + fixType + '\'' +
                "} " + super.toString();
    }

    public String toStringCsv(){
        return getId()+","+getName()+","+getPrice()+","+getNumberPhoneHave()+","+getFactory()+","+country+","+fixType;
    }
}
