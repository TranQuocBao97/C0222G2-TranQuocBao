package bai_tap_lam_them_test.model.sub_vehicle;

import bai_tap_lam_them_test.model.Vehicle;

public class Motorbike extends Vehicle {
    private Integer power;

    public Motorbike(){

    }

    public Motorbike(Integer power) {
        this.power = power;
    }

    public Motorbike(String idControl, String companyName, Integer yearProduct, String owner, Integer power) {
        super(idControl, companyName, yearProduct, owner);
        this.power = power;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", power=" + power;
    }
}
