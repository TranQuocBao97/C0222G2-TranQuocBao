package program.ung_dung_khach_san.repository.repository_customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.ung_dung_khach_san.model.entities_customer.Gender;

import java.util.List;

@Repository
public interface IGenderRepository extends JpaRepository<Gender, Integer> {
    List<Gender> findAll();
}
