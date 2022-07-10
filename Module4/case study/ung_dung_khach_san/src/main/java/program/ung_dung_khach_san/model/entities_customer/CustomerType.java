package program.ung_dung_khach_san.model.entities_customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_type_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "customerType")
    private List<Customer> customers;
}
