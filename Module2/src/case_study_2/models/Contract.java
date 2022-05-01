package case_study_2.models;

public class Contract {
    private String idContract;
    private String bookingInformation;
    private Double depositMoney;
    private Double totalMoney;

    public Contract() {
    }

    public Contract(String idContract, String bookingInformation, Double depositMoney, Double totalMoney) {
        this.idContract = idContract;
        this.bookingInformation = bookingInformation;
        this.depositMoney = depositMoney;
        this.totalMoney = totalMoney;
    }

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public String getBookingInformation() {
        return bookingInformation;
    }

    public void setBookingInformation(String bookingInformation) {
        this.bookingInformation = bookingInformation;
    }

    public Double getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(Double depositMoney) {
        this.depositMoney = depositMoney;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "[Contract: " +
                "idContract: " + idContract +
                ", bookingInformation: " + bookingInformation +
                ", depositMoney: " + String.format("%.0f",depositMoney) +
                ", totalMoney: " + String.format("%.0f",totalMoney)+"]";
    }

    public String propertiesToCsv(){
        return idContract+","+bookingInformation+","+depositMoney+","+totalMoney;
    }
}
