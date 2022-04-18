package bai_tap_lam_them_test.model;

public class Company {
    protected Integer idCompany;
    private String nameCompany;
    private String countryCompany;

    public Company() {
    }

    public Company(Integer idCompany, String nameCompany, String countryCompany) {
        this.idCompany = idCompany;
        this.nameCompany = nameCompany;
        this.countryCompany = countryCompany;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getCountryCompany() {
        return countryCompany;
    }

    public void setCountryCompany(String countryCompany) {
        this.countryCompany = countryCompany;
    }

    @Override
    public String toString() {
        return  "idCompany=" + idCompany +
                ", nameCompany=" + nameCompany +
                ", countryCompany=" + countryCompany;
    }
}
