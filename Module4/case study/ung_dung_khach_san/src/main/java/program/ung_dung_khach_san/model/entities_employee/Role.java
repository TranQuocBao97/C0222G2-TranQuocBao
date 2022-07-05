package program.ung_dung_khach_san.model.entities_employee;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<Account> accounts;

}
