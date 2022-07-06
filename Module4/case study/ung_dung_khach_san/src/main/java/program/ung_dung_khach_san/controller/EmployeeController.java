package program.ung_dung_khach_san.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/list")
    public String getListPageEmployee(){
        return "/list-employee-page";
    }

}
