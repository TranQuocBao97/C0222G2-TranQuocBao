package program.quan_ly_khach_hang_phan_trang_tim_kiem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import program.quan_ly_khach_hang_phan_trang_tim_kiem.model.Customer;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = " SELECT * FROM customers ", nativeQuery = true)
    List<Customer> selectAllCustomer();

    @Query(value = " SELECT * from customers WHERE customer_id = :id ",nativeQuery = true)
    Customer getCustomerById(@Param("id") Integer id);



    @Modifying
    @Transactional
    Customer save(Customer customer);

    @Modifying
    @Transactional
    void deleteById(Integer integer);



}
