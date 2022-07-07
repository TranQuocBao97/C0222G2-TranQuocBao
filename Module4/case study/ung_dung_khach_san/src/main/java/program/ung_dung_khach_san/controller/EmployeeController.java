package program.ung_dung_khach_san.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import program.ung_dung_khach_san.model.entities_employee.Employee;
import program.ung_dung_khach_san.service.service_employee.IEmployeeService;



@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/list")
    public String getListPageEmployee(@PageableDefault(5) Pageable pageable,
                                      Model model){
        Page<Employee> employeePage = iEmployeeService.findAll(pageable);
        model.addAttribute("employeePage",employeePage);
        return "/list-employee-page";
    }

}
