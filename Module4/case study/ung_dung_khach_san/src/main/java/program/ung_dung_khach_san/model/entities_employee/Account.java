package program.ung_dung_khach_san.model.entities_employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @Column(name="username")
    private String username;
    private String password;

    @JsonBackReference
    @OneToOne(mappedBy = "account")
    private Employee employee;
    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "account_role",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
