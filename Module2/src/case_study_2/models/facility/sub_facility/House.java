package case_study_2.models.facility.sub_facility;

import case_study_2.models.facility.Facility;

public class House extends Facility {
    private String typeFacility;
    private Integer numberFloors;

    public House(String typeFacility, Integer numberFloors) {
        this.typeFacility = typeFacility;
        this.numberFloors = numberFloors;
    }

    public House(Integer idFacility, String name, Double area, Double pricePerDay, Double pricePerHour, String typeRent, String typeFacility, Integer numberFloors) {
        super(idFacility, name, area, pricePerDay, pricePerHour, typeRent);
        this.typeFacility = typeFacility;
        this.numberFloors = numberFloors;
    }

    public String getTypeFacility() {
        return typeFacility;
    }

    public void setTypeFacility(String typeFacility) {
        this.typeFacility = typeFacility;
    }

    public Integer getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(Integer numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return super.toString()+
                "typeFacility: " + typeFacility +
                ", numberFloors: " + numberFloors+". ";
    }
}
