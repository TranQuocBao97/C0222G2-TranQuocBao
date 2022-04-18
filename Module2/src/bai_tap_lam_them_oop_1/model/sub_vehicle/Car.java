package bai_tap_lam_them_oop_1.model.sub_vehicle;

import bai_tap_lam_them_oop_1.model.Vehicle;

public class Car extends Vehicle {
    private int numberSeats;
    private String carType;

    public Car() {
    }

    public Car(int idControl, String companyName, int yearProduct, String owner, int numberSeats, String carType) {
        super(idControl, companyName, yearProduct, owner);
        this.numberSeats = numberSeats;
        this.carType = carType;
    }


    public int getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idControl = " + idControl +
                ", company = (" + companyName +
                "), yearProduct = " + yearProduct +
                ", owner = '" + owner + '\'' +
                ", numberSeats = " + numberSeats +
                ", carType = '" + carType + '\'' +
                "} ";
    }
}
