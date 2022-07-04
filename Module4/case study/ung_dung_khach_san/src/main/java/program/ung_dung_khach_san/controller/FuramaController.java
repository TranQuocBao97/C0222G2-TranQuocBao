package program.ung_dung_khach_san.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuramaController {

    @GetMapping
    public String homePage(){
        return "home-page";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
