package program.ung_dung_khach_san.common.validate_date_format;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatValidate implements ConstraintValidator<ValidateDateFormat, String> {

    public static boolean checkDateFormat(String dateString) {
        boolean flag = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate localDate = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean isValid(String dateString, ConstraintValidatorContext context) {
       return checkDateFormat(dateString);
    }
}
