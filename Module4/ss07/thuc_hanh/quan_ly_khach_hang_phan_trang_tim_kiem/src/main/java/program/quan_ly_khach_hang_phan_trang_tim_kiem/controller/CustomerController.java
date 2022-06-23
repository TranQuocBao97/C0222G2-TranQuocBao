package program.quan_ly_khach_hang_phan_trang_tim_kiem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import program.quan_ly_khach_hang_phan_trang_tim_kiem.model.Customer;
import program.quan_ly_khach_hang_phan_trang_tim_kiem.service.ICustomerService;
import program.quan_ly_khach_hang_phan_trang_tim_kiem.service.IProvinceService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IProvinceService iProvinceService;

    @GetMapping("/list-customer")
    public String displayList(Model model){
        List<Customer> customerList = iCustomerService.getAllCustomer();
        model.addAttribute("customers",customerList);
        return "customer-list";
    }

    @GetMapping("/create-customer")
    public String displayCreate(Model model){
        model.addAttribute("customer",new Customer());
        model.addAttribute("provinces",iProvinceService.getAllProvince());
        return "customer-create";
    }

    @PostMapping("/add")
    public String addCustomer(Customer customer){
        this.iCustomerService.addCustomer(customer);
        return "redirect:/customer/list-customer";
    }


}
