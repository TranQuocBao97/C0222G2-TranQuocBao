package calculator.service;

import calculator.service.interface_service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {
    @Override
    public Double checkRate(Double usd) {
        return usd * 23000;
    }
}
