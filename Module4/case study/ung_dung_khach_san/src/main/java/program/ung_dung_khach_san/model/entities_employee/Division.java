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
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "division_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "division")
    private List<Employee> employees;


}
