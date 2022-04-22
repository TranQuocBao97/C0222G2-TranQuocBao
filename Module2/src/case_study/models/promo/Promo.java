package case_study.models.promo;

public class Promo {
    private Integer promoTicket;

    public Promo(Integer promoTicket) {
        this.promoTicket = promoTicket;
    }

    public Integer getPromoTicket() {
        return promoTicket;
    }

    public void setPromoTicket(Integer promoTicket) {
        this.promoTicket = promoTicket;
    }

    @Override
    public String toString() {
        return "PromoTicket=" + promoTicket+".";
    }
}
