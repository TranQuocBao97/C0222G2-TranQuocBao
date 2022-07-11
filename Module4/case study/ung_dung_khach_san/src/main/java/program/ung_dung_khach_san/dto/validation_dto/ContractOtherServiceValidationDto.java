package program.ung_dung_khach_san.dto.validation_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import program.ung_dung_khach_san.model.Contract;
import program.ung_dung_khach_san.model.OtherService;

import javax.validation.constraints.Positive;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractOtherServiceValidationDto {
    private Integer id;
    private Contract contract;
    private OtherService otherService;
    @Positive(message = "Phải là số nguyên dương")
    private Integer amount;
}
