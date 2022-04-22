package case_study.models;

public class Contract extends Booking{
    private double moneyDeposit;
    private double moneyTotal;

    public Contract() {
    }

    public Contract(double moneyDeposit, double moneyTotal) {
        this.moneyDeposit = moneyDeposit;
        this.moneyTotal = moneyTotal;
    }

    public Contract(Integer idBooking, String informationCustomerBooking, String informationFacilityBooking, Integer startDate, Integer endDate, double moneyDeposit, double moneyTotal) {
        super(idBooking, informationCustomerBooking, informationFacilityBooking, startDate, endDate);
        this.moneyDeposit = moneyDeposit;
        this.moneyTotal = moneyTotal;
    }

    public double getMoneyDeposit() {
        return moneyDeposit;
    }

    public void setMoneyDeposit(double moneyDeposit) {
        this.moneyDeposit = moneyDeposit;
    }

    public double getMoneyTotal() {
        return moneyTotal;
    }

    public void setMoneyTotal(double moneyTotal) {
        this.moneyTotal = moneyTotal;
    }

    @Override
    public String toString() {
        return super.toString() +
                " moneyDeposit: " + moneyDeposit +
                ", moneyTotal: " + moneyTotal+".";
    }
}
