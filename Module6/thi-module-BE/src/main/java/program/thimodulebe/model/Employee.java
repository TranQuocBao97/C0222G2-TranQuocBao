package program.thimodulebe.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Integer id;

    @Column(unique = true, nullable = false)
    private String code;

    private String name;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "position_id",referencedColumnName = "position_id")
    private Position position;

    @OneToMany(mappedBy = "employee")
    private List<ProductOrder> productOrders;
}
