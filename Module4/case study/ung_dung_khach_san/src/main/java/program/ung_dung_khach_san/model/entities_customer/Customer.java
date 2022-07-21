package program.ung_dung_khach_san.model.entities_customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import program.ung_dung_khach_san.model.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Integer id;
    private String name;
    @Column(columnDefinition = "DATE")
    private String dateOfBirth;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "gender_id",nullable = false,referencedColumnName = "gender_id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", nullable = false, referencedColumnName = "customer_type_id")
    private CustomerType customerType;

    @JsonBackReference
    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;


}
