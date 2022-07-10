package program.ung_dung_khach_san.model.entities_employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employees;


}
