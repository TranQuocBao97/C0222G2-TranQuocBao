package program.ung_dung_khach_san.model.entities_employee;

import lombok.Data;
import program.ung_dung_khach_san.model.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Integer id;
    private String name;
    @Column(columnDefinition = "DATE")
    private String dateOfBirth;
    private String idCard;
    private Double salary;
    private String phoneNumber;
    private String address;

    @ManyToOne
    @JoinColumn(name="position_id", nullable = false, referencedColumnName = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name="education_id", nullable = false, referencedColumnName = "education_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name="division_id",nullable = false,referencedColumnName = "division_id")
    private Division division;


    @OneToMany(mappedBy = "employee")
    private List<Contract> contracts;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="email",referencedColumnName = "username")
    private Account account;



}
