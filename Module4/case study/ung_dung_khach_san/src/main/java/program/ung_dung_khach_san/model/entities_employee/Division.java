package program.ung_dung_khach_san.model.entities_employee;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "division_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "division")
    private List<Employee> employees;


}
