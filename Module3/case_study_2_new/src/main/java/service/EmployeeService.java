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
        if(!Validate.checkDateType(employee.getBirthday())){
            errorMap.put("birthday","Ngày sinh không hơp lệ");
        }else if(!Validate.checkBirthdayTime(employee.getBirthday())){
            errorMap.put("birthday","Lỗi ngày sinh lớn hơn ngày hiện tại");
        }
        if(!Validate.checkIdCard(employee.getIdCard())){
            errorMap.put("idCard","IdCard phải là 9 hoặc 12 số");
        }else if(Validate.checkIdCardEmployeeAlreadyExist(employee.getIdCard())){
            errorMap.put("idCard","IdCard đã tồn tại");
        }

        if(employee.getSalary()==null){
            errorMap.put("salary","Lương phải là số và không được để trống");
        }else if(!Validate.checkPositiveNumber(employee.getSalary())){
            errorMap.put("salary","Lương phải là số dương");
        }

        if(!Validate.checkPhone(employee.getPhone())){
            errorMap.put("phone","Phone phải 10 số và bắt đầu với đầu số 090 hoặc 091");
        }else if(Validate.checkPhoneEmployeeAlreadyExist(employee.getPhone())){
            errorMap.put("phone","Số điẹn thoại đã tồn tại");
        }
        if(!Validate.checkEmail(employee.getEmail())){
            errorMap.put("email","Email phải có đúng định dạng x@x.x (ví dụ: abc@mail.com)");
        }else if(Validate.checkEmailEmployeeAlreadyExist(employee.getEmail())){
            errorMap.put("email","Email đã tồn tại");
        }
        if(employee.getAddress().isEmpty()){
            errorMap.put("address","Address không được để trống");
        } else if(!Validate.checkStringEmpty(employee.getAddress())){
            errorMap.put("address","Address chỉ có khoảng trắng");
        }
        if(!Validate.checkPositionIdAvailable(employee.getEmployeePosition().getPositionId())){
            errorMap.put("position","Position không tồn tại");
        }
        if(!Validate.checkEducationIdAvailable(employee.getEducationDegree().getEducationDegreeId())){
            errorMap.put("education","Education không tồn tại");
        }
        if(!Validate.checkDivisionAvailable(employee.getDivision().getDivisionId())){
            errorMap.put("division","Division không tồn tại");
        }
        if(errorMap.isEmpty()){
            boolean checkAdd = iEmployeeRepository.addEmployee(employee);
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
    public Map<String,String> editEmployee(Employee employee) {
        Map<String,String> errorMap = new HashMap<>();
        if(!Validate.checkName(employee.getName())){
            errorMap.put("name","Tên không hợp lệ");
        }
        if(!Validate.checkDateType(employee.getBirthday())){
            errorMap.put("birthday","Ngày sinh không hơp lệ");
        }else if(!Validate.checkBirthdayTime(employee.getBirthday())){
            errorMap.put("birthday","Lỗi ngày sinh lớn hơn ngày hiện tại");
        }
        if(!Validate.checkIdCard(employee.getIdCard())){
            errorMap.put("idCard","IdCard phải là 9 hoặc 12 số");
        }

        if(employee.getSalary()==null){
            errorMap.put("salary","Lương phải là số và không được để trống");
        }else if(!Validate.checkPositiveNumber(employee.getSalary())){
            errorMap.put("salary","Lương phải là số dương");
        }

        if(!Validate.checkPhone(employee.getPhone())){
            errorMap.put("phone","Phone phải 10 số và bắt đầu với đầu số 090 hoặc 091");
        }
        if(!Validate.checkEmail(employee.getEmail())){
            errorMap.put("email","Email phải có đúng định dạng x@x.x (ví dụ: abc@mail.com)");
        }
        if(employee.getAddress().isEmpty()){
            errorMap.put("address","Address không được để trống");
        } else if(!Validate.checkStringEmpty(employee.getAddress())){
            errorMap.put("address","Address chỉ có khoảng trắng");
        }
        if(!Validate.checkPositionIdAvailable(employee.getEmployeePosition().getPositionId())){
            errorMap.put("position","Position không tồn tại");
        }
        if(!Validate.checkEducationIdAvailable(employee.getEducationDegree().getEducationDegreeId())){
            errorMap.put("education","Education không tồn tại");
        }
        if(!Validate.checkDivisionAvailable(employee.getDivision().getDivisionId())){
            errorMap.put("division","Division không tồn tại");
        }
        if(errorMap.isEmpty()){
            boolean checkAdd = iEmployeeRepository.editEmployee(employee);
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
    public List<EmployeeDTO> searchAllEmployeeDTO(String searchId, String searchName, String searchPosition, String searchDivision) {
        return iEmployeeRepository.searchAllEmployeeDTO(searchId,searchName,searchPosition,searchDivision);
    }
}
