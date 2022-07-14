package program.ung_dung_khach_san.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OtherService {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "other_service_id")
    private Integer id;
    private String name;
    private Double cost;
    private Integer amount;


    @OneToMany(mappedBy = "otherService")
    @JsonBackReference
    private List<ContractOtherService> contractOtherServices;
}
