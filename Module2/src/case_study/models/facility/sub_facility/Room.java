package case_study.models.facility.sub_facility;

import case_study.models.facility.AbsFacility;

public class Room extends AbsFacility {
    private String direction;

    public Room(){

    }


    public Room(String direction) {
        this.direction = direction;
    }

    public Room(Integer idFacility, String area, Integer price, String extraService, String direction) {
        super(idFacility, area, price, extraService);
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", direction: " + direction+". ";
    }
}
