package model;

public class Service {
    private Integer serviceId;
    private String serviceName;
    private Double serviceArea;
    private Double serviceCost;
    private Integer serviceMaxPeople;
    private String serviceStandardRoom;
    private String serviceDescription;
    private Double servicePoolArea;
    private Integer serviceNumberFloor;
    private RentType RentType;
    private ServiceType serviceType;

    public Service() {
    }

    public Service(Integer serviceId, String serviceName, Double serviceArea, Double serviceCost, Integer serviceMaxPeople, String serviceStandardRoom, String serviceDescription, Double servicePoolArea, Integer serviceNumberFloor, model.RentType rentType, ServiceType serviceType) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.serviceStandardRoom = serviceStandardRoom;
        this.serviceDescription = serviceDescription;
        this.servicePoolArea = servicePoolArea;
        this.serviceNumberFloor = serviceNumberFloor;
        RentType = rentType;
        this.serviceType = serviceType;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Double serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getServiceStandardRoom() {
        return serviceStandardRoom;
    }

    public void setServiceStandardRoom(String serviceStandardRoom) {
        this.serviceStandardRoom = serviceStandardRoom;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public Double getServicePoolArea() {
        return servicePoolArea;
    }

    public void setServicePoolArea(Double servicePoolArea) {
        this.servicePoolArea = servicePoolArea;
    }

    public Integer getServiceNumberFloor() {
        return serviceNumberFloor;
    }

    public void setServiceNumberFloor(Integer serviceNumberFloor) {
        this.serviceNumberFloor = serviceNumberFloor;
    }

    public model.RentType getRentType() {
        return RentType;
    }

    public void setRentType(model.RentType rentType) {
        RentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
