package program.thimodulebe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_order_id")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String code;

    private String customerName;

    private Integer quantity;


    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @JsonIgnore
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
    @JsonIgnore
    private Bill bill;

}
