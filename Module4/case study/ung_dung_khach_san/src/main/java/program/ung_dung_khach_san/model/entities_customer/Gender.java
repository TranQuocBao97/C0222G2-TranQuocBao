package program.ung_dung_khach_san.model.entities_customer;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gender_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "gender")
    private List<Customer> customers;
}
