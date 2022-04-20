package case_study.models.facility;

public abstract class AbsFacility {
    protected Integer idFacility;
    protected String area;
    protected Integer numberOfRooms;
    protected String extraService;

    public AbsFacility() {
    }

    public AbsFacility(Integer idFacility,String area, Integer numberOfRooms, String extraService) {
        this.idFacility =idFacility;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.extraService = extraService;
    }


    public Integer getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(Integer idFacility) {
        this.idFacility = idFacility;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getExtraService() {
        return extraService;
    }

    public void setExtraService(String extraService) {
        this.extraService = extraService;
    }

    @Override
    public String toString() {
        return "id Facility: "+ idFacility+
                ", area: " + area +
                ", numberOfRooms: " + numberOfRooms +
                ", extraService: " + extraService;
    }
}
