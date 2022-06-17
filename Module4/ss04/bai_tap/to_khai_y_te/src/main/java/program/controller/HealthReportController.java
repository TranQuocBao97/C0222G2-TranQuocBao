package program.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import program.model.HealthReport;
import program.service.IHealthReportService;

@Controller
@RequestMapping("/report")
public class HealthReportController {

    @Autowired
    IHealthReportService iHealthReportService;

    @GetMapping("/form")
    public String getForm(ModelMap modelMap) {
        modelMap.addAttribute("healthReport", new HealthReport());
        return "health-report-homepage";
    }


    @GetMapping("/list-from")
    public String showList(ModelMap modelMap) {
        modelMap.addAttribute("listHealthReport", iHealthReportService.showList());
        return "list-report";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam String dateStart,
                         ModelMap modelMap) {
        HealthReport healthReport = iHealthReportService.getReport(dateStart);
        modelMap.addAttribute("healthReport",healthReport);
        return "detail-report";
    }

    @PostMapping("/add-form")
    public String addForm(@ModelAttribute HealthReport healthReport,
                          RedirectAttributes redirectAttributes) {
        iHealthReportService.addReportList(healthReport);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");

        return "redirect:/report/list-from";
    }


}
