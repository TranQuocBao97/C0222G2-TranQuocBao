package repository.interface_customer_repository;

import model.Employee;
import modelDTO.EmployeeDTO;

import java.util.List;
import java.util.Map;

public interface IEmployeeRepository {
    boolean addEmployee(Employee employee);

    List<EmployeeDTO> getAllEmployeeDTO();

    boolean deleteEmployeeById(Integer id);

    boolean editEmployee(Employee employee);

    List<EmployeeDTO> searchAllEmployeeDTO(String searchId, String searchName, String searchPosition, String searchDivision);
}
