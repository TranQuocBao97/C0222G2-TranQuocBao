package program.ung_dung_khach_san.dto.validation_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import program.ung_dung_khach_san.common.validate_date_format.ValidateDateFormat;
import program.ung_dung_khach_san.model.Contract;
import program.ung_dung_khach_san.model.entities_employee.Account;
import program.ung_dung_khach_san.model.entities_employee.Division;
import program.ung_dung_khach_san.model.entities_employee.EducationDegree;
import program.ung_dung_khach_san.model.entities_employee.Position;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeValidationDto implements Validator {
    private Integer id;
    @Pattern(regexp = "^([A-Z][^A-Z0-9\\s]+)(\\s[A-Z][^A-Z0-9\\s]+)*$",
            message = "Tên khách hàng không được chứa số. Và các kí tự đầu tiên của mỗi từ phải viết hoa")
    private String name;

    @ValidateDateFormat
    private String dateOfBirth;

    @Pattern(regexp = "^[0-9]{9}|[0-9]{12}$", message = "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    private String idCard;

    @Min(value = 1,message = "Phải là số dương")
    private Double salary;

    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$",
            message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phoneNumber;
    private String address;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private List<Contract> contracts;

    private Account account;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeValidationDto employeeValidationDto = (EmployeeValidationDto) target;
        String regex = "^[a-zA-z0-9]+@[a-z]+\\.com$";
        if(!employeeValidationDto.account.getUsername().matches(regex)){
            errors.rejectValue("account","create.account","Email cần đúng định dạng");
        }
    }
}
