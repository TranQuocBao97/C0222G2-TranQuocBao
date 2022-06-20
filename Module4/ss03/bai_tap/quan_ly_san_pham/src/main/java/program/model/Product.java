package program.model;

public class Product {
    private Integer id;
    private String name;
    private String price;
    private String information;

    public Product() {
    }



    public Product(Integer id, String name, String price, String information) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.information = information;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
