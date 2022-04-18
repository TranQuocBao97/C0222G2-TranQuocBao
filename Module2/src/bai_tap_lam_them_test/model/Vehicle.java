package bai_tap_lam_them_test.model;

public class Vehicle {
    protected String idControl;
    protected String companyName;
    protected Integer yearProduct;
    protected String owner;

    public Vehicle() {
    }

    public Vehicle(String idControl, String companyName, Integer yearProduct, String owner) {
        this.idControl = idControl;
        this.companyName = companyName;
        this.yearProduct = yearProduct;
        this.owner = owner;
    }

    public String getIdControl() {
        return idControl;
    }

    public void setIdControl(String idControl) {
        this.idControl = idControl;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getYearProduct() {
        return yearProduct;
    }

    public void setYearProduct(Integer yearProduct) {
        this.yearProduct = yearProduct;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return  "idControl=" + idControl +
                ", companyName=(" + companyName +
                "), yearProduct=" + yearProduct +
                ", owner=" + owner;
    }
}
