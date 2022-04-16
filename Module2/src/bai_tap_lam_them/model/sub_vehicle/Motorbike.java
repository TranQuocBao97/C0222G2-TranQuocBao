package bai_tap_lam_them.model.sub_vehicle;

import bai_tap_lam_them.model.Vehicle;

public class Motorbike extends Vehicle {
    private int horsePower;

    public Motorbike() {
    }

    public Motorbike(int idControl, String companyName, int yearProduct, String owner, int horsePower) {
        super(idControl, companyName, yearProduct, owner);
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "idControl = " + idControl +
                ", company = (" + companyName +
                "), yearProduct = " + yearProduct +
                ", owner = '" + owner + '\'' +
                ", horsePower = " + horsePower +
                "} ";
    }
}
