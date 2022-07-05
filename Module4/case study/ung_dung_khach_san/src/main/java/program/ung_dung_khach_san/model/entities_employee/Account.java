package program.ung_dung_khach_san.model.entities_employee;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Account {
    @Id
    @Column(name="username")
    private String username;
    private String password;

    @OneToOne(mappedBy = "account")
    private Employee employee;

    @ManyToMany
    @JoinTable(name = "account_role",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
