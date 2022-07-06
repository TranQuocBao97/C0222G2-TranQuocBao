package program.ung_dung_khach_san.service.service_customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import program.ung_dung_khach_san.model.entities_customer.Customer;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
}
