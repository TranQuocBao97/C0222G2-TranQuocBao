package program.service;

import org.springframework.stereotype.Service;
import program.service.interface_service.ICalculatorService;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public Double doMath(Double num1, Double num2, String math) {
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
        return result;
    }
}
