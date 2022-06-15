package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.interface_service.IDictionaryService;

@Controller
public class DictionaryController {

    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping (value = "/dictionaryHomePage")
    public String translate(@RequestParam String english,
                                      Model model){
        String vietNam = iDictionaryService.findEnglishWord(english);
        model.addAttribute("vietNam",vietNam);
        model.addAttribute("english",english);
        return "dictionaryHome";
    }
}
