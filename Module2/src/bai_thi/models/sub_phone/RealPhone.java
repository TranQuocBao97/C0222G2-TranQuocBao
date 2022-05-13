package bai_thi.models.sub_phone;

import bai_thi.models.Phone;

public class RealPhone extends Phone {
    private Integer timeSupport;
    private String areaSupport;

    public RealPhone(int timeSupport, String areaSupport) {
        this.timeSupport = timeSupport;
        this.areaSupport = areaSupport;
    }

    public RealPhone(Integer id, String name, Integer price, Integer numberPhoneHave, String factory, Integer timeSupport, String areaSupport) {
        super(id, name, price, numberPhoneHave, factory);
        this.timeSupport = timeSupport;
        this.areaSupport = areaSupport;
    }

    public int getTimeSupport() {
        return timeSupport;
    }

    public void setTimeSupport(Integer timeSupport) {
        this.timeSupport = timeSupport;
    }

    public String getAreaSupport() {
        return areaSupport;
    }

    public void setAreaSupport(String areaSupport) {
        this.areaSupport = areaSupport;
    }

    @Override
    public String toString() {
        return "RealPhone{" +
                "timeSupport=" + timeSupport +
                ", areaSupport='" + areaSupport + '\'' +
                "} " + super.toString();
    }

    public String toStringCsv(){
        return getId()+","+getName()+","+getPrice()+","+getNumberPhoneHave()+","+getFactory()+","+timeSupport+","+areaSupport;
    }
}
