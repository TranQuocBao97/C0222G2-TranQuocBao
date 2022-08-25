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
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_type_id")
    private Integer id;

    private String name;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "productType")
    @JsonIgnore
    private List<Product> products;
}
