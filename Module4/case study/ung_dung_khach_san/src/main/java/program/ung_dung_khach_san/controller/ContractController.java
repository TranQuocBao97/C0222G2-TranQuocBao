package program.ung_dung_khach_san.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import program.ung_dung_khach_san.model.Contract;
import program.ung_dung_khach_san.model.ContractOtherService;
import program.ung_dung_khach_san.model.OtherService;
import program.ung_dung_khach_san.repository.repository_contract.IContractOtherServiceRepository;
import program.ung_dung_khach_san.repository.repository_contract.IOtherServiceRepository;
import program.ung_dung_khach_san.repository.repository_customer.ICustomerRepository;
import program.ung_dung_khach_san.service.service_contract.IContractService;
import program.ung_dung_khach_san.service.service_customer.ICustomerService;
import program.ung_dung_khach_san.service.service_employee.IEmployeeService;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IOtherServiceRepository iOtherServiceRepository;
    @Autowired
    private IContractOtherServiceRepository iContractOtherServiceRepository;


    @GetMapping("/list")
    public String getListPageContract(@PageableDefault(5) Pageable pageable,
                                      Model model){
        Page<Contract> contractPage = iContractService.findAll(pageable);
        List<OtherService> otherServiceList = iOtherServiceRepository.findAll();
        model.addAttribute("contractPage",contractPage);
        model.addAttribute("otherServiceList", otherServiceList);
        model.addAttribute("contractOtherServiceObj",new ContractOtherService());
        return "/list-contract-page";
    }

//    @PostMapping("/addContractOtherService")
//    public String addContractOtherService(@ModelAttribute ){
//
//    }
}
