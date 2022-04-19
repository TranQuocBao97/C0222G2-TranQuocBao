package case_study.models.facility;

public abstract class AbsFacility {
    protected String area;
    protected Integer numberOfRooms;
    protected String extraService;

    public AbsFacility() {
    }

    public AbsFacility(String area, Integer numberOfRooms, String extraService) {
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.extraService = extraService;
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
        return "area: " + area +
                ", numberOfRooms: " + numberOfRooms +
                ", extraService: " + extraService;
    }
}
