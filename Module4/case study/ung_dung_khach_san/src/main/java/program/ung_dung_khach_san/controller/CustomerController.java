package program.ung_dung_khach_san.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import program.ung_dung_khach_san.model.entities_customer.Customer;
import program.ung_dung_khach_san.repository.repository_customer.ICustomerTypeRepository;
import program.ung_dung_khach_san.repository.repository_customer.IGenderRepository;
import program.ung_dung_khach_san.service.service_customer.ICustomerService;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IGenderRepository iGenderRepository;
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @GetMapping("/list")
    public String getListPageCustomer(@PageableDefault(5)Pageable pageable,
                                      Model model,
                                      @RequestParam Optional<String> searchByNameCustomer){
        String nameSearchVal = searchByNameCustomer.orElse("");
        Page<Customer> customerPage = iCustomerService.findAllByName(nameSearchVal, pageable);
        model.addAttribute("customerPage",customerPage);
        model.addAttribute("genderList",iGenderRepository.findAll());
        model.addAttribute("customerTypeList",iCustomerTypeRepository.findAll());
        model.addAttribute("customerObj",new Customer());
        model.addAttribute("nameSearchVal",nameSearchVal);
        return "/list-customer-page";
    }

    @PostMapping("/add")
    public String addNewCustomer(@ModelAttribute Customer customer,
                                 RedirectAttributes redirectAttributes){
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/customer/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteCustomerById(@PathVariable Integer id,
                                     RedirectAttributes redirectAttributes){
        if(!iCustomerService.existsById(id)){
            redirectAttributes.addFlashAttribute("mess","Xóa thất bại");
            return "redirect:/customer/list";
        }
        iCustomerService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/customer/list";
    }



}
