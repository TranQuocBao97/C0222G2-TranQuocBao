package program.ung_dung_khach_san.common.validate_email_customer;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailCustomerValidate.class)
@Documented
public @interface ValidateEmailCustomer {
    String message() default "Email khách hàng đã tồn tại";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
