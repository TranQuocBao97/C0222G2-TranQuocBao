package program.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import program.model.EmailSetting;
import program.service.interface_service.ISettingService;

@Controller
public class SettingController {

//    @Autowired
//    ISettingService iSettingService;




    @GetMapping(value = "/showFormSetting")
    public String showFormSetting(ModelMap modelMap){
        modelMap.addAttribute("EmailSetting",new EmailSetting());
        return "setting-home-page";
    }


    @PostMapping(value = "/saveSetting")
    public String saveSetting(@ModelAttribute EmailSetting emailSetting,
                              ModelMap modelMap){
        modelMap.addAttribute("language",emailSetting.getLanguage());
        modelMap.addAttribute("pageSize",emailSetting.getPageSize());
        modelMap.addAttribute("spamFilter",emailSetting.getSpamFilter());
        modelMap.addAttribute("signature",emailSetting.getSignature());

        return "user-setting";
    }
}
