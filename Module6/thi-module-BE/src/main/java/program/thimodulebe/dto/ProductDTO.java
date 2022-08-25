package program.thimodulebe.dto;

import lombok.Data;
import program.thimodulebe.model.ProductOrder;
import program.thimodulebe.model.ProductType;

import javax.persistence.Column;
import java.sql.Date;
import java.util.List;

@Data
public class ProductDTO {
    private Integer id;

//    @Column(unique = true, nullable = false)
    private String code;

    private String name;

    private Double price;

    private String company;

    private Date dateCreateProduct;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isGas;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean cakeSugar;

    private String writer;

    private String bookType;

    @Column(columnDefinition = "DATE")
    private String dateCreateBook;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean status;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;


    private ProductType productType;

    private List<ProductOrder> productOrders;
}
