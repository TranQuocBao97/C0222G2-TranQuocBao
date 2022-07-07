package program.ung_dung_khach_san.repository.repository_employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import program.ung_dung_khach_san.model.entities_employee.Employee;

import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findAll(Pageable pageable);

    void deleteById(Integer id);

    boolean existsById(Integer id);

    Employee save(Employee employee);

    Optional<Employee> findById(Integer id);
}
