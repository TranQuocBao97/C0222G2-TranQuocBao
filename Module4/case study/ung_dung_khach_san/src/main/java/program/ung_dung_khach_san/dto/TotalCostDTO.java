package program.ung_dung_khach_san.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TotalCostDTO {
    @Id
    @Column(name="contract_id")
    private Integer id;

    @Column(name="total_cost")
    private Double totalCost;
}
