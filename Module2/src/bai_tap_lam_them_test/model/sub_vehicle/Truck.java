package bai_tap_lam_them_test.model.sub_vehicle;

import bai_tap_lam_them_test.model.Vehicle;

public class Truck extends Vehicle {
    private String deadWeight;

    public Truck(){

    }

    public Truck(String deadWeight) {
        this.deadWeight = deadWeight;
    }

    public Truck(String idControl, String companyName, Integer yearProduct, String owner, String deadWeight) {
        super(idControl, companyName, yearProduct, owner);
        this.deadWeight = deadWeight;
    }

    public String getDeadWeight() {
        return deadWeight;
    }

    public void setDeadWeight(String deadWeight) {
        this.deadWeight = deadWeight;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", deadWeight=" + deadWeight;
    }
}
