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
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bill_id")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String code;

    private Double totalPrice;

    private Date creationDate;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "bill")
    private List<ProductOrder> productOrders;
}
