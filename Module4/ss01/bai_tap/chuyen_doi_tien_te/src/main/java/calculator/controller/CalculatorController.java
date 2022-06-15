package calculator.controller;

import calculator.service.interface_service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService icalculatorService;

    @GetMapping (value = "/UsdToVnd")
    public String checkUsdToVnd(@RequestParam Double usd,
                                Model model){
        Double vnd = icalculatorService.checkRate(usd);
        model.addAttribute("vnd",vnd);
        model.addAttribute("usd",usd);
        return "displayCalculator";
    }
}
