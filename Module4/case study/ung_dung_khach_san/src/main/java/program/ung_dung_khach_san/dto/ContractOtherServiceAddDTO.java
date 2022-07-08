package program.ung_dung_khach_san.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import program.ung_dung_khach_san.model.Contract;
import program.ung_dung_khach_san.model.ContractOtherService;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractOtherServiceAddDTO {
    private Contract contract;
    private ContractOtherService contractOtherService;
}
