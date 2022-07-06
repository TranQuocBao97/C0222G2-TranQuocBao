package program.ung_dung_khach_san.repository.repository_employee;

import org.springframework.data.jpa.repository.JpaRepository;
import program.ung_dung_khach_san.model.entities_employee.EducationDegree;

public interface iEducationDeFreeRepository extends JpaRepository<EducationDegree,Integer> {
}
