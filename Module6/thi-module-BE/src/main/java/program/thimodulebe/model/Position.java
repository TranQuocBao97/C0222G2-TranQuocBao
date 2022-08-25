package program.thimodulebe.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="position_id")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "position")
    private List<Employee> employees;
}
