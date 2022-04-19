package case_study.models.facility.sub_facility;

import case_study.models.facility.AbsFacility;

public class House extends AbsFacility {
    private Integer numberOfFloors;

    public House(){

    }
    public House(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public House(String area, Integer numberOfRooms, String extraService, Integer numberOfFloors) {
        super(area, numberOfRooms, extraService);
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
                ", numberOfFloors: " + numberOfFloors;
    }
}
