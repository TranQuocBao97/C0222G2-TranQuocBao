package model;

public class Floor {
    private Integer floorId;
    private Integer floorNumber;

    public Floor() {
    }

    public Floor(Integer floorId, Integer floorNumber) {
        this.floorId = floorId;
        this.floorNumber = floorNumber;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }
}
