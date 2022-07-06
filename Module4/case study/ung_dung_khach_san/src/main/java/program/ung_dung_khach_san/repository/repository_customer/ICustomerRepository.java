package program.ung_dung_khach_san.repository.repository_customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.ung_dung_khach_san.model.entities_customer.Customer;
import program.ung_dung_khach_san.model.entities_facility.Facility;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAll(Pageable pageable);

    void deleteById(Integer id);

    boolean existsById(Integer id);

    Customer save(Facility facility);

    Optional<Customer> findById(Integer id);
}
