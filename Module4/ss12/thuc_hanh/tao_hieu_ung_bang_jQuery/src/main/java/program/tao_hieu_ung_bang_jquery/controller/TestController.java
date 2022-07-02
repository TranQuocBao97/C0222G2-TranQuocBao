package program.tao_hieu_ung_bang_jquery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping
    public String displayTest(){
        return "test";
    }

    @GetMapping("/test2")
    public String displayTest2(){
        return "test2";
    }
}
