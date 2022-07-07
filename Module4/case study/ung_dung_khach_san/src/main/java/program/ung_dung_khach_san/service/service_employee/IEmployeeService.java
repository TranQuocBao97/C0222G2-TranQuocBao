package program.ung_dung_khach_san.service.service_employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import program.ung_dung_khach_san.model.entities_employee.Employee;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
}
