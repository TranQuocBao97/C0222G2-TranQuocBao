package program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import program.service.interface_service.ICalculatorService;

@Controller
@RequestMapping(value = "/calculator")
public class CalculatorController {

    @Autowired
    ICalculatorService iCalculatorService;

    @GetMapping(value = "/home")
    public String homePageCalculator(){
        return "calculatorPage";
    }


    @GetMapping(value = "/do-math")
    public String calculator(@RequestParam Double num1,
                             @RequestParam Double num2,
                             @RequestParam String math,
                             Model model){
        Double result = iCalculatorService.doMath(num1,num2,math);
        model.addAttribute("num1",num1);
        model.addAttribute("num2",num2);
        model.addAttribute("result",result);

        return "calculatorPage";
    }
}
