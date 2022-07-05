package com.codegym.controller;

import com.codegym.service.ISumService;
import com.codegym.service.impl.SumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SumController {

    @Autowired
    private ISumService iSumService;

    @GetMapping(value = "/sum")
    public String sum2Num(@RequestParam int number1,
                          @RequestParam(value = "number2") int b,
                          Model model) {

        int result2Num = this.iSumService.sum(number1, b);
        model.addAttribute("result2Num", result2Num);

        // /WEB-INF/views/ + result + .jsp
        return "result";
    }
}
