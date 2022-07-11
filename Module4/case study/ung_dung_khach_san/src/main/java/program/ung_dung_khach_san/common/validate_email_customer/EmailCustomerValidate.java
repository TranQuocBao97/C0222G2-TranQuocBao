package program.ung_dung_khach_san.common.validate_email_customer;

import org.springframework.beans.factory.annotation.Autowired;
import program.ung_dung_khach_san.model.entities_customer.Customer;
import program.ung_dung_khach_san.repository.repository_customer.ICustomerRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EmailCustomerValidate implements ConstraintValidator<ValidateEmailCustomer,String> {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        List<Customer> customerList= iCustomerRepository.findAll();
        for (Customer customer : customerList){
            if(customer.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }
}
