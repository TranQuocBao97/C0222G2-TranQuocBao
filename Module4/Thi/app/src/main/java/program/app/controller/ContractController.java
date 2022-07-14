package program.app.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import program.app.dto.ContractDto;
import program.app.model.Contract;
import program.app.repository.IContractRepository;
import program.app.repository.IRoomRepository;
import program.app.service.impl.IContractService;

import javax.validation.Valid;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IContractRepository iContractRepository;
    @Autowired
    private IRoomRepository iRoomRepository;

    @GetMapping("/list")
    public String showListContract(@PageableDefault(5) Pageable pageable,
                                   Model model){
        Page<Contract> contractPage = iContractService.findAll(pageable);
        model.addAttribute("contractPage",contractPage);
        return "list-contract-page";
    }

    @GetMapping("/addPage")
    public String showAddPage(Model model){
        model.addAttribute("roomList",iRoomRepository.findAll());
        model.addAttribute("contractDto",new ContractDto());
        return "add-page";
    }

    @PostMapping("/add")
    public String addContract(@ModelAttribute("contractDto") @Valid ContractDto contractDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model){
        new ContractDto().validate(contractDto,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("roomList",iRoomRepository.findAll());
            return "add-page";
        }
        if (iContractRepository.existsByNameContract(contractDto.getNameContract())) {
            model.addAttribute("roomList",iRoomRepository.findAll());
            model.addAttribute("mess","ID contract already exist");
            return "add-page";
        }
        Contract contract = new Contract();
        contractDto.getRoom().setStatus(1);
        BeanUtils.copyProperties(contractDto,contract);


        iContractRepository.save(contract);
        redirectAttributes.addFlashAttribute("mess","Add new contract success!");
        return "redirect:/contract/list";
    }
}
