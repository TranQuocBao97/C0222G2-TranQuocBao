package program.ung_dung_khach_san.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractOtherService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false, referencedColumnName = "contract_id")
    private Contract contract;


    @ManyToOne
    @JoinColumn(name = "otherService_id", nullable = false, referencedColumnName = "other_service_id")
    private OtherService otherService;


    private Integer amount;
}
