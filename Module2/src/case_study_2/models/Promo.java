package case_study_2.models;

public class Promo {
    private String idCustomer;
    private String voucher;

    public Promo() {
    }

    public Promo(String idCustomer, String voucher) {
        this.idCustomer = idCustomer;
        this.voucher = voucher;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    @Override
    public String toString() {
        return "Promo: " +
                "[idCustomer: "  + idCustomer +
                ", voucher: " + voucher+"]";
    }
}
