package model;

public class TotalPrice {
    private String contractId;
    private String totalPrice;

    public TotalPrice() {
    }

    public TotalPrice(String contractId, String totalPrice) {
        this.contractId = contractId;
        this.totalPrice = totalPrice;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
