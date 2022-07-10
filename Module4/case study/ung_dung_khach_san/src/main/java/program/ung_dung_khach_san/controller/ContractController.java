package program.ung_dung_khach_san.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import program.ung_dung_khach_san.dto.ContractOtherServiceAddDTO;
import program.ung_dung_khach_san.dto.TotalCostDTO;
import program.ung_dung_khach_san.model.Contract;
import program.ung_dung_khach_san.model.ContractOtherService;
import program.ung_dung_khach_san.repository.repository_contract.IContractOtherServiceRepository;
import program.ung_dung_khach_san.repository.repository_contract.IContractRepository;
import program.ung_dung_khach_san.repository.repository_contract.IOtherServiceRepository;
import program.ung_dung_khach_san.repository.repository_contract.ITotalCostDtoRepository;
import program.ung_dung_khach_san.repository.repository_customer.ICustomerRepository;
import program.ung_dung_khach_san.repository.repository_employee.IEmployeeRepository;
import program.ung_dung_khach_san.repository.repository_facility.IFacilityRepository;
import program.ung_dung_khach_san.service.service_contract.IContractService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IContractRepository iContractRepository;
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private IFacilityRepository iFacilityRepository;
    @Autowired
    private IOtherServiceRepository iOtherServiceRepository;

    @Autowired
    private IContractOtherServiceRepository iContractOtherServiceRepository;


    @Autowired
    private ITotalCostDtoRepository iTotalCostDtoRepository;

    @GetMapping("/list")
    public String getListPageContract(@PageableDefault(5) Pageable pageable,
                                      Model model,
                                      @RequestParam Optional<String> searchValue) {
        String search = searchValue.orElse("");
        Page<Contract> contractPage = iContractService.findAllByStartDateContaining(search, pageable);
        model.addAttribute("contractObj", new Contract());
        model.addAttribute("contractPage", contractPage);
        model.addAttribute("otherServiceList", iOtherServiceRepository.findAll());
        model.addAttribute("employeeList", iEmployeeRepository.findAll());
        model.addAttribute("customerList", iCustomerRepository.findAll());
        model.addAttribute("facilityList", iFacilityRepository.findAll());
        model.addAttribute("contractOtherServiceObj", new ContractOtherService());
        model.addAttribute("contractOtherServiceAddDTO", new ContractOtherServiceAddDTO());

        List<TotalCostDTO> totalCostDTOList = iTotalCostDtoRepository.selectTotalCost();
        model.addAttribute("totalCostDTOList",totalCostDTOList);

        if (contractPage.isEmpty()) {
            model.addAttribute("pageEmpty", "Không tìm thấy kết quả");
        }
        return "/list-contract-page";
    }

    @PostMapping("/add")
    public String addContract(@ModelAttribute("contractOtherServiceAddDTO") ContractOtherServiceAddDTO contractOtherServiceAddDTO,
                              RedirectAttributes redirectAttributes) {
        Contract contractForAdd = iContractService.save(contractOtherServiceAddDTO.getContract());
        try {
            if (contractOtherServiceAddDTO.getContractOtherService().getOtherService().getId() != null) {
                ContractOtherService contractOtherServiceForAdd = contractOtherServiceAddDTO.getContractOtherService();
                contractOtherServiceForAdd.setContract(contractForAdd);
                iContractOtherServiceRepository.save(contractOtherServiceForAdd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("mess", "Thêm mới hợp đồng thành công");
        return "redirect:/contract/list";
    }

    @PostMapping("/addContractOtherService")
    public String addContractOtherService(@ModelAttribute ContractOtherService contractOtherService,
                                          RedirectAttributes redirectAttributes) {
        List<ContractOtherService> contractOtherServiceList = iContractOtherServiceRepository.findAll();
        for (ContractOtherService c : contractOtherServiceList) {
            if (c.getOtherService().getId().equals(contractOtherService.getOtherService().getId())) {
                c.setAmount(c.getAmount() + contractOtherService.getAmount());
                iContractOtherServiceRepository.save(c);
                redirectAttributes.addFlashAttribute("mess"
                        , "Tăng thêm số lượng dịch vụ mở rộng cho hợp đồng thành công");
                return "redirect:/contract/list";
            }
        }
        iContractOtherServiceRepository.save(contractOtherService);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới dịch vụ mở rộng cho hợp đồng thành công");
        return "redirect:/contract/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteContract(@PathVariable Integer id,
                                 RedirectAttributes redirectAttributes) {
        iContractOtherServiceRepository.deleteContractOtherServicesByContractId(id);
        iContractService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess", "xóa thành công");
        return "redirect:/contract/list";
    }
}
