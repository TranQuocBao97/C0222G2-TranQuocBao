package case_study_2.models.facility;

public abstract class Facility {
    private Integer idFacility;
    private String name;
    private Double area;
    private Double pricePerDay;
    private Double pricePerHour;
    private String typeRent;

    public Facility() {
    }

    public Facility(Integer idFacility, String name, Double area, Double pricePerDay, Double pricePerHour, String typeRent) {
        this.idFacility = idFacility;
        this.name = name;
        this.area = area;
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.typeRent = typeRent;
    }

    public Integer getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(Integer idFacility) {
        this.idFacility = idFacility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    @Override
    public String toString() {
        return "idFacility: " + idFacility +
                ", name: " + name +
                ", area: " + area +
                ", pricePerDay: " + pricePerDay +
                ", pricePerHour: " + pricePerHour +
                ", typeRent: " + typeRent+". ";
    }
}
