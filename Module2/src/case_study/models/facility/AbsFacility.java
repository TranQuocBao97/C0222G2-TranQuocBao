package case_study.models.facility;

public abstract class AbsFacility {
    protected Integer idFacility;
    protected String area;
    protected Integer price;
    protected String extraService;

    public AbsFacility() {
    }

    public AbsFacility(Integer idFacility, String area, Integer price, String extraService) {
        this.idFacility =idFacility;
        this.area = area;
        this.price = price;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
                ", price: " + price +
                ", extraService: " + extraService;
    }
}
