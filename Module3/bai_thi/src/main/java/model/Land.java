package model;

public class Land {
    private String id;
    private Double area;
    private Integer statusId;
    private Integer floorNumber;
    private Integer typeId;
    private String information;
    private Double price;
    private String dateStart;
    private String dateEnd;

    public Land() {
    }

    public Land(String id, Double area, Integer statusId, Integer floorNumber, Integer typeId, String information, Double price, String dateStart, String dateEnd) {
        this.id = id;
        this.area = area;
        this.statusId = statusId;
        this.floorNumber = floorNumber;
        this.typeId = typeId;
        this.information = information;
        this.price = price;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}
