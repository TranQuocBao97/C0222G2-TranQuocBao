package model;

public class EmployeePosition {
    private Integer positionId;
    private String name;
    public EmployeePosition(Integer positionId, String name) {
        this.positionId = positionId;
        this.name = name;
    }
    public EmployeePosition() {
    }

    public EmployeePosition(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
