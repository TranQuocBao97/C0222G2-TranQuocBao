package bai_tap_lam_them_test.model.sub_vehicle;

import bai_tap_lam_them_test.model.Vehicle;

public class Car extends Vehicle {
    private Integer numberSeats;
    private String carType;

    public Car() {
    }

    public Car(Integer numberSeats, String carType) {
        this.numberSeats = numberSeats;
        this.carType = carType;
    }

    public Car(String idControl, String companyName, Integer yearProduct, String owner, Integer numberSeats, String carType) {
        super(idControl, companyName, yearProduct, owner);
        this.numberSeats = numberSeats;
        this.carType = carType;
    }

    public Integer getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(Integer numberSeats) {
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
        return  super.toString() +
                ", numberSeats=" + numberSeats +
                ", carType=" + carType;
    }
}
