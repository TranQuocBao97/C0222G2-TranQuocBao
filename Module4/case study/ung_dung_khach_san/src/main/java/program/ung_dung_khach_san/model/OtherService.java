package program.ung_dung_khach_san.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class OtherService {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "other_service_id")
    private Integer id;
    private String name;
    private Double cost;
    private Integer amount;

    @ManyToMany(mappedBy = "otherServices")
    private Set<Contract> contracts;
}
