package calculator.controller;

import calculator.service.interface_service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetHomePage {
    @Autowired
    private ICalculatorService icalculatorService;

    @GetMapping(value = "/home")
    public String homePage(){
        return "displayCalculator";
    }
}
