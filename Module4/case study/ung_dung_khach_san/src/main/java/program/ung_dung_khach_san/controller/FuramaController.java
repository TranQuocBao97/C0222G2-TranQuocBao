package program.ung_dung_khach_san.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/furama")
public class FuramaController {

    @GetMapping("/home")
    public String homePage(){
        return "home-page";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
