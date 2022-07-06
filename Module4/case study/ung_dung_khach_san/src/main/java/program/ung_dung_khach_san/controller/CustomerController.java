package program.ung_dung_khach_san.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import program.ung_dung_khach_san.model.entities_customer.Customer;
import program.ung_dung_khach_san.service.service_customer.ICustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/list")
    public String getListPageCustomer(@PageableDefault(5)Pageable pageable,
                                      Model model){
        Page<Customer> customerPage = iCustomerService.findAll(pageable);
        model.addAttribute("customerPage",customerPage);
        return "/list-customer-page";
    }

}
