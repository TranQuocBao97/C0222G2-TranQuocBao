package program.ung_dung_khach_san.dto.validation_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import program.ung_dung_khach_san.model.Contract;
import program.ung_dung_khach_san.model.entities_facility.FacilityType;
import program.ung_dung_khach_san.model.entities_facility.RentType;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityValidationDto {
    private Integer id;
    @Pattern(regexp = "^([A-Z][^A-Z\\s]+)(\\s[A-Z][^A-Z\\s]+)*$", message = "Tên dịch vụ được phép chứa số. Và các kí tự đầu tiên của mỗi từ phải viết hoa")
    private String name;

    private Double area;
    private Double cost;
    private String standardRoom;
    private String convenience;
    private Double poolArea;

    @Positive(message = "Phải là số nguyên dương")
    private Integer numberOfFloors;
    private String facilityFree;
    private FacilityType facilityType;
    private RentType rentType;
    private List<Contract> contracts;
}
