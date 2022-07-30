package program.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pack_id")
    private Integer id;

    private String nameId;
    private Integer amount;
    private String dateIn;
    private String dateProduct;
    private String dateOver;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false,referencedColumnName = "product_id")
    private Product product;
}
