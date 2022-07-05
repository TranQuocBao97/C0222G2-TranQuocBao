package com.codegym.controller;

import com.codegym.service.ISumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @Autowired
    private ISumService iSumService;

    @GetMapping(value = "/greeting")
    public String goGreeting() {
        return "greeting";
    }
}
