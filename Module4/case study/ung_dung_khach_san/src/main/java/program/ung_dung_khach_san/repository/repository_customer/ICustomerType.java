package program.ung_dung_khach_san.repository.repository_customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.ung_dung_khach_san.model.entities_customer.CustomerType;

import java.util.List;

@Repository
public interface ICustomerType extends JpaRepository<CustomerType, Integer> {
    List<CustomerType> findAll();
}
