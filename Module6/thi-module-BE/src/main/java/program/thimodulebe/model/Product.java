package program.thimodulebe.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Integer id;

    @Column(unique = true, nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "product_type_id")
    private ProductType productType;

    @OneToMany(mappedBy = "product")
    private List<ProductOrder> productOrders;
}
