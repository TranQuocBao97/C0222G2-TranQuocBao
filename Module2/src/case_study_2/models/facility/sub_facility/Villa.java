package case_study_2.models.facility.sub_facility;

public class Villa extends House{
    private String areaPool;

    public Villa(String typeFacility, Integer numberFloors, String areaPool) {
        super(typeFacility, numberFloors);
        this.areaPool = areaPool;
    }

    public Villa(Integer idFacility, String name, Double area, Double pricePerDay, Double pricePerHour, String typeRent, String typeFacility, Integer numberFloors, String areaPool) {
        super(idFacility, name, area, pricePerDay, pricePerHour, typeRent, typeFacility, numberFloors);
        this.areaPool = areaPool;
    }

    public String getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(String areaPool) {
        this.areaPool = areaPool;
    }

    @Override
    public String toString() {
        return super.toString()+
                "areaPool: " + areaPool;
    }
}
