package program.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping ("/sandwich")
public class SandwichController {

    @GetMapping(value = "/home")
    public String homePageSandwich(){
        return "sandwich_homePage";
    }

    @GetMapping(value= "/save")
    public String saveSandwich(@RequestParam("condiment") String[] condiment,
                               Model model){
        model.addAttribute("condiment",condiment);

        return "sandwich_homePage";
    }
}
