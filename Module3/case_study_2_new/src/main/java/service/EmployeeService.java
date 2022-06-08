package service;

import model.Employee;
import modelDTO.EmployeeDTO;
import repository.EmployeeRepository;
import repository.interface_customer_repository.IEmployeeRepository;
import service.interface_service.IEmployeeService;
import validate.Validate;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository iEmployeeRepository = new EmployeeRepository();
    @Override
    public Map<String, String> addEmployee(Employee employee) {
        Map<String,String> errorMap = new HashMap<>();
        if(!Validate.checkName(employee.getName())){
            errorMap.put("name","Tên không hợp lệ");
        }
        if(!Validate.checkIdCard(employee.getIdCard())){
            errorMap.put("idCard","IdCard phải là 9 số");
        }
        if(!Validate.checkSalary(employee.getSalary())){
            errorMap.put("salary","Lương phải là số");
        }
        if(!Validate.checkPhone(employee.getPhone())){
            errorMap.put("phone","Phone phải 10 số và bắt đầu từ số 0");
        }
        if(!Validate.checkEmail(employee.getEmail())){
            errorMap.put("email","Email phải có đúng định dạng x@x.x");
        }
        System.out.println(employee.getEmail());
        if(errorMap.isEmpty()){
            boolean checkAdd = iEmployeeRepository.addEmployee(employee);
            System.out.println("?");
            Map<String,String> messMap = new HashMap<>();
            if(checkAdd){
                messMap.put("mess","true");
            }else {
                messMap.put("mess","false");
            }
            return messMap;
        }
        return errorMap;
    }

    @Override
    public List<EmployeeDTO> getAllEmployeeDTO() {
        return iEmployeeRepository.getAllEmployeeDTO();
    }

    @Override
    public boolean deleteEmployeeById(Integer id) {
        return iEmployeeRepository.deleteEmployeeById(id);
    }

    @Override
    public boolean editEmployee(Employee employee) {
        return iEmployeeRepository.editEmployee(employee);
    }

    @Override
    public List<EmployeeDTO> searchAllEmployeeDTO(String searchId, String searchName, String searchPosition, String searchDivision) {
        return iEmployeeRepository.searchAllEmployeeDTO(searchId,searchName,searchPosition,searchDivision);
    }
}
