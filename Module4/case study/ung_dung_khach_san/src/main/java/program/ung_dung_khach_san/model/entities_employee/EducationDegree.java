package program.ung_dung_khach_san.model.entities_employee;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employees;


}
