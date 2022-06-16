package program.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/calculator")
public class CalculatorController {

    @GetMapping(value = "/home")
    public String homePageCalculator(){
        return "calculatorPage";
    }


    @GetMapping(value = "/do-math")
    public String calculator(@RequestParam Double num1,
                             @RequestParam Double num2,
                             @RequestParam String math,
                             Model model){
        Double result = null;
        switch (math){
            case "add":
                result = num1+num2;
                break;
            case "sub":
                result =num1-num2;
                break;
            case "mul":
                result = num1*num2;
                break;
            case "div":
                result =num1/num2;
                break;
        }
        model.addAttribute("num1",num1);
        model.addAttribute("num2",num2);
        model.addAttribute("result",result);

        return "calculatorPage";
    }
}
