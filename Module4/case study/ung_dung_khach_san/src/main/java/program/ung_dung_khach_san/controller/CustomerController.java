package program.ung_dung_khach_san.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import program.ung_dung_khach_san.dto.validation_dto.CustomerValidationDto;
import program.ung_dung_khach_san.dto.validation_dto.EmployeeValidationDto;
import program.ung_dung_khach_san.model.entities_customer.Customer;
import program.ung_dung_khach_san.repository.repository_customer.ICustomerTypeRepository;
import program.ung_dung_khach_san.repository.repository_customer.IGenderRepository;
import program.ung_dung_khach_san.service.service_customer.ICustomerService;

import javax.validation.Valid;
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
        if (!model.containsAttribute("customerObj")) {
            model.addAttribute("customerObj",new CustomerValidationDto());
        }
        String nameSearchVal = searchByNameCustomer.orElse("");
        Page<Customer> customerPage = iCustomerService.findAllByName(nameSearchVal, pageable);
        model.addAttribute("customerPage",customerPage);
        model.addAttribute("genderList",iGenderRepository.findAll());
        model.addAttribute("customerTypeList",iCustomerTypeRepository.findAll());
//        model.addAttribute("customerObj",new Customer());
        model.addAttribute("nameSearchVal",nameSearchVal);
        if(customerPage.isEmpty()){
            model.addAttribute("pageEmpty","Không tìm thấy kết quả");
        }
        return "/list-customer-page";
    }

    @PostMapping("/add")
    public String addNewCustomer(@Validated @ModelAttribute("customerObj") CustomerValidationDto customer,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model){

        if(bindingResult.hasErrors()){
//            bindingResult.getFieldErrors();
            redirectAttributes.addFlashAttribute("checkValidate","error");
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.customerObj",bindingResult);
            redirectAttributes.addFlashAttribute("customerObj",customer);
            return "redirect:/customer/list";
        }
        Customer realCustomer = new Customer();
        BeanUtils.copyProperties(customer,realCustomer);
        iCustomerService.save(realCustomer);

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
