package bai_thi.models;

public abstract class Phone {
    private Integer id;
    private String name;
    private Integer price;
    private Integer numberPhoneHave;
    private String factory;

    public Phone() {
    }

    public Phone(Integer id, String name, Integer price, Integer numberPhoneHave, String factory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.numberPhoneHave = numberPhoneHave;
        this.factory = factory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumberPhoneHave() {
        return numberPhoneHave;
    }

    public void setNumberPhoneHave(Integer numberPhoneHave) {
        this.numberPhoneHave = numberPhoneHave;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", numberPhoneHave=" + numberPhoneHave +
                ", factory='" + factory + '\'' +
                '}';
    }
}
