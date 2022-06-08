package service.interface_service;

import model.Employee;
import modelDTO.EmployeeDTO;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    Map<String, String> addEmployee(Employee employee);

    List<EmployeeDTO> getAllEmployeeDTO();

    boolean deleteEmployeeById(Integer id);

    boolean editEmployee(Employee employee);

    List<EmployeeDTO> searchAllEmployeeDTO(String searchId, String searchName, String searchPosition, String searchDivision);
}
