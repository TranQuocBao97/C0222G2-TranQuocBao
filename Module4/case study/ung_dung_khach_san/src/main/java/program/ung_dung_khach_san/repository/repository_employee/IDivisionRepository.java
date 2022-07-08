package program.ung_dung_khach_san.repository.repository_employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.ung_dung_khach_san.model.entities_employee.Division;

import java.util.List;

@Repository
public interface IDivisionRepository extends JpaRepository<Division,Integer> {
    List<Division> findAll();
}
