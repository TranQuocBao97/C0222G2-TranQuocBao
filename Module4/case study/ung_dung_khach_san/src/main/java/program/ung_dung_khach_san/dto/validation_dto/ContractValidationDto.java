package program.ung_dung_khach_san.dto.validation_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import program.ung_dung_khach_san.common.validate_date_format.ValidateDateFormat;
import program.ung_dung_khach_san.model.ContractOtherService;
import program.ung_dung_khach_san.model.entities_customer.Customer;
import program.ung_dung_khach_san.model.entities_employee.Employee;
import program.ung_dung_khach_san.model.entities_facility.Facility;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractValidationDto implements Validator {
    private Integer id;

    @FutureOrPresent
    @ValidateDateFormat
    private String startDate;
    @Future
    @ValidateDateFormat
    private String endDate;

    @Min(value = 100000,message = "Tiền đặt cọc phải trên 100k")
    private Double deposit;
    private Employee employee;
    private Customer customer;
    private Facility facility;
    private List<ContractOtherService> contractOtherServices;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractValidationDto contractValidationDto = (ContractValidationDto) target;
        Date start;
        Date end;
        try {
            start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            end  = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if(start.getTime()>end.getTime()){
            errors.rejectValue("endDate", "create.endDate","Ngày trả phòng phải sau ngày đặt phòng");
        }
    }
}
