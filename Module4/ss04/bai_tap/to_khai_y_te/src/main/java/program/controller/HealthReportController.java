package program.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import program.model.HealthReport;

@Controller
@RequestMapping("/report")
public class HealthReportController {

    @GetMapping("/form")
    public String getForm(ModelMap modelMap ){
        modelMap.addAttribute("healthReport",new HealthReport());
        return "health-report-homepage";
    }



}
