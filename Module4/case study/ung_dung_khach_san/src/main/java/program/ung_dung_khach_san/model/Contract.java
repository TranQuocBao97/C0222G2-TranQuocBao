package program.ung_dung_khach_san.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import program.ung_dung_khach_san.model.entities_customer.Customer;
import program.ung_dung_khach_san.model.entities_employee.Employee;
import program.ung_dung_khach_san.model.entities_facility.Facility;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="contract_id")
    private Integer id;
    @Column(columnDefinition = "DATE")
    private String startDate;
    @Column(columnDefinition = "DATE")
    private String endDate;
    private Double deposit;




    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false,referencedColumnName = "employee_id")
    private Employee employee;



    @ManyToOne
    @JoinColumn(name= "customer_id", nullable = false, referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="facility_id", nullable = false, referencedColumnName = "facility_id")
    @JsonBackReference
    private Facility facility;


    @OneToMany(mappedBy = "contract")
    private List<ContractOtherService> contractOtherServices;


}
