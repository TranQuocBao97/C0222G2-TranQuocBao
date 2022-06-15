package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import service.interface_service.IDictionaryService;

@Controller
public class HomePage {

    @GetMapping(value = "/home")
    public String homePage(){
        return "dictionaryHome";
    }
}
