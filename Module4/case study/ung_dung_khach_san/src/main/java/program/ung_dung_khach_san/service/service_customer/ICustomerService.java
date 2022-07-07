package program.ung_dung_khach_san.service.service_customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import program.ung_dung_khach_san.model.entities_customer.Customer;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByName(String name,Pageable pageable);
    void save(Customer customer);

    Optional<Customer> findById(Integer id);

    void deleteById(Integer id);

    boolean existsById(Integer id);
}
