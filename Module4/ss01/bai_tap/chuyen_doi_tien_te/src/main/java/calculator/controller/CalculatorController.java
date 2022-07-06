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

    public static void main(String[] args) {
        int[] arr = {3,8,1};
        int n = 4;
        int sumNew = 0;
        int sumOld = 0;
        int sum = 0;
        int num1 = 0;
        for (int i = 0; i < arr.length-1; i++) {
            num1 = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if(num1<arr[j]){
                    sumNew = n - num1 + arr[j];
                }
                if(sumNew>sumOld){
                    sum = sumNew;
                }
            }
        }
        if(sum>n){
            System.out.println(sum);
        }else {
            System.out.println(n);
        }
    }
}
