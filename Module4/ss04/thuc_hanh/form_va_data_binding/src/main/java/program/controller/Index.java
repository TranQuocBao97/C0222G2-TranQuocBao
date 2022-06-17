package program.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {

    @GetMapping  (value = "")
    public String indexPage(){
        return "index";
    }
}
