package model;

public class CustomerType {
    private Integer CustomerTypeId;
    private String CustomerTypeName;

    public CustomerType() {
    }

    public CustomerType(Integer customerTypeId, String customerTypeName) {
        CustomerTypeId = customerTypeId;
        CustomerTypeName = customerTypeName;
    }

    public Integer getCustomerTypeId() {
        return CustomerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        CustomerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return CustomerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        CustomerTypeName = customerTypeName;
    }
}
