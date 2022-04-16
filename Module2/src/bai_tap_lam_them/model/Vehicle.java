package bai_tap_lam_them.model;

public abstract class Vehicle {
    protected int idControl;
    protected String companyName;
    protected int yearProduct;
    protected String owner;

    public Vehicle() {
    }

    public Vehicle(int idControl, String companyName, int yearProduct, String owner) {
        this.idControl = idControl;
        this.companyName = companyName;
        this.yearProduct = yearProduct;
        this.owner = owner;
    }

    public int getIdControl() {
        return idControl;
    }

    public void setIdControl(int idControl) {
        this.idControl = idControl;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getYearProduct() {
        return yearProduct;
    }

    public void setYearProduct(int yearProduct) {
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
        return "Vehicle{" +
                "idControl=" + idControl +
                '}';
    }
}
