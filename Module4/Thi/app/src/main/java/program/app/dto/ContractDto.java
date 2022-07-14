package program.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import program.app.model.Room;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto implements Validator {

    private Integer id;

    @Pattern(regexp = "^HD-[0-9]{4}",message = "HD-XXXX, XXXX là số")
    private String nameContract;

    @Pattern(regexp = "^([A-Z][^A-Z0-9\\s]+)(\\s[A-Z][^A-Z0-9\\s]+)*$",
            message = "Tên không được chứa số. Và các kí tự đầu tiên của mỗi từ phải viết hoa")
    private String personName;

    @NotBlank(message = "Không được để trống")
    private String idCard;

    private String dateRent;

    private String timeRent;

    private Double totalPrice;

    private Room room;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        LocalDate localDateNow = LocalDate.now();
        Date start;
        Date now;
        if(contractDto.dateRent.equals("")){
            errors.rejectValue("dateRent", "create.dateRent","Ngày đặt phòng phải lớn hơn hiện tại");
        }
        try {
            start = new SimpleDateFormat("yyyy-MM-dd").parse(contractDto.dateRent);
            now = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(localDateNow));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if(start.getTime()<now.getTime()){
            errors.rejectValue("dateRent", "create.dateRent","Ngày đặt phòng phải lớn hơn hiện tại");
        }
    }
}
