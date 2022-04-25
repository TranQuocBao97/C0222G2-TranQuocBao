package ss17_io_binary_file_and_serialization.bai_tap.quan_li_danh_sach_nhi_phan.models;

import java.io.Serializable;

public class ProductSs17 implements Serializable {
    private String id;
    private String name;
    private String company;
    private Integer price;
    private String information;

    public ProductSs17() {
    }

    public ProductSs17(String id, String name, String company, Integer price, String information) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.price = price;
        this.information = information;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "ProductSs17{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", information='" + information + '\'' +
                '}';
    }
}
