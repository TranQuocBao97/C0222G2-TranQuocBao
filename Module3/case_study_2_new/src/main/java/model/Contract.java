package model;

public class Contract {
    private Integer id;
    private String dateStart;
    private String dateEnd;
    private Double deposit;
    private Double totalMoney;
    private Integer employeeId;
    private Integer customerId;
    private Integer serviceId;

    public Contract() {
    }

    public Contract(Integer id) {
        this.id = id;
    }

    public Contract(Integer id, String dateStart, String dateEnd, Double deposit, Double totalMoney, Integer employeeId, Integer customerId, Integer serviceId) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }
}
