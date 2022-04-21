package case_study.models.facility.sub_facility;

import case_study.models.facility.AbsFacility;

import java.util.Objects;

public class House extends AbsFacility {
    private Integer numberOfFloors;

    public House(){

    }

    public House(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public House(Integer idFacility, String area, Integer price, String extraService, Integer numberOfFloors) {
        super(idFacility, area, price, extraService);
        this.numberOfFloors = numberOfFloors;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numberOfFloors: " + numberOfFloors+". ";
    }

    @Override
    public boolean equals(Object o) {
        House house = (House) o;
        return idFacility.equals(house.idFacility);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFacility);
    }
}
