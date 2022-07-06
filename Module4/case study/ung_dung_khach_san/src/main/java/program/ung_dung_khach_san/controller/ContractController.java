package program.ung_dung_khach_san.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @GetMapping("/list")
    public String getListPageContract(){
        return "/list-contract-page";
    }
}
