package program.ung_dung_khach_san.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import program.ung_dung_khach_san.model.entities_employee.Employee;
import program.ung_dung_khach_san.repository.repository_employee.IDivisionRepository;
import program.ung_dung_khach_san.repository.repository_employee.IEducationDegreeRepository;
import program.ung_dung_khach_san.repository.repository_employee.IPositionRepository;
import program.ung_dung_khach_san.service.service_employee.IEmployeeService;

import java.util.Optional;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IDivisionRepository iDivisionRepository;
    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;
    @Autowired
    private IPositionRepository iPositionRepository;

    @GetMapping("/list")
    public String getListPageEmployee(@PageableDefault(5) Pageable pageable,
                                      @RequestParam Optional<String> nameSearch,
                                      Model model) {
        String nameSearchValue = nameSearch.orElse("");
        Page<Employee> employeePage = iEmployeeService.findAllByNameContaining(nameSearchValue, pageable);
        model.addAttribute("employeePage", employeePage);
        model.addAttribute("nameSearchValue", nameSearchValue);
        model.addAttribute("divisionList",iDivisionRepository.findAll());
        model.addAttribute("educationList",iEducationDegreeRepository.findAll());
        model.addAttribute("positionList",iPositionRepository.findAll());
        model.addAttribute("employeeObj",new Employee());
        if(employeePage.isEmpty()){
            model.addAttribute("pageEmpty","Không tìm thấy kết quả");
        }
        return "/list-employee-page";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable Integer id,
                                     RedirectAttributes redirectAttributes) {
        iEmployeeService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/employee/list";
    }

    @PostMapping("/add")
    public String addNewEmployee(@ModelAttribute Employee employee,
                                 RedirectAttributes redirectAttributes){
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("mess", "thêm mới thành công");
        return "redirect:/employee/list";
    }

}
