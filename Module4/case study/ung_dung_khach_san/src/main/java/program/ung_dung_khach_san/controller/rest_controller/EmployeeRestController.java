package program.ung_dung_khach_san.controller.rest_controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.ung_dung_khach_san.model.entities_employee.Employee;
import program.ung_dung_khach_san.repository.repository_employee.IEmployeeRepository;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/employee")
public class EmployeeRestController {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @PutMapping
    public ResponseEntity<Void> EditEmployee(@RequestBody Employee employee){
        iEmployeeRepository.save(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getListEmployee(){
        List<Employee> employeeList = iEmployeeRepository.findAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

}
