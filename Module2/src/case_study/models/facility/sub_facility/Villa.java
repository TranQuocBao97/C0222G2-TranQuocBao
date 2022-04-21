package case_study.models.facility.sub_facility;

import case_study.models.facility.AbsFacility;

public class Villa extends AbsFacility {
    private String location;

    public Villa(){
    }



    public Villa(String location) {
        this.location = location;
    }

    public Villa(Integer idFacility, String area, Integer price, String extraService, String location) {
        super(idFacility, area, price, extraService);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", location: " + location+". ";
    }
}
