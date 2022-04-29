package case_study_2.models.facility.sub_facility;

import case_study_2.models.facility.Facility;

public class Room extends Facility {
    private String bonus;

    public Room(String bonus) {
        this.bonus = bonus;
    }

    public Room(String idFacility, String name, Double area, Double pricePerDay, Double pricePerHour, String typeRent, String bonus) {
        super(idFacility, name, area, pricePerDay, pricePerHour, typeRent);
        this.bonus = bonus;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.toString()+
                "bonus: " + bonus;
    }
    public String propertiesToCsv(){
        return getIdFacility()+","+getName()+","+getArea()+","+getPricePerDay()+","+getPricePerHour()+","
                +getTypeRent()+","+bonus;
    }
}
