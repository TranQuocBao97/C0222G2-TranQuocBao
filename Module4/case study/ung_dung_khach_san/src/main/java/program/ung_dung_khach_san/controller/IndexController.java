package program.ung_dung_khach_san.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping
    public String homePage() {
        return "home-page";
    }
}
