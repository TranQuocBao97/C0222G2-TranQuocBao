package program.ung_dung_khach_san.repository.repository_employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.ung_dung_khach_san.model.entities_employee.Division;

@Repository
public interface iDivisionRepository extends JpaRepository<Division,Integer> {
}
