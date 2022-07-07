package program.ung_dung_khach_san.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import program.ung_dung_khach_san.model.Contract;
import program.ung_dung_khach_san.model.OtherService;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractOtherServiceDTO {
    private List<Contract> contractList;
    private List<OtherService> otherServiceList;
}
