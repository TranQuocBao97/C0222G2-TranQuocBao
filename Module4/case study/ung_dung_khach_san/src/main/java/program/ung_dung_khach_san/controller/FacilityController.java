package program.ung_dung_khach_san.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import program.ung_dung_khach_san.model.entities_facility.Facility;
import program.ung_dung_khach_san.repository.repository_facility.IFacilityTypeRepository;
import program.ung_dung_khach_san.repository.repository_facility.IRentTypeRepository;
import program.ung_dung_khach_san.service.service_facility.IFacilityService;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;
    @Autowired
    private IRentTypeRepository iRentTypeRepository;



    @GetMapping("/list")
    public String getListPageFacility(Model model,
                                      @PageableDefault(5) Pageable pageable){
        Page<Facility> facilityPage = iFacilityService.findAll(pageable);
        model.addAttribute("facilityPage",facilityPage);
        model.addAttribute("facilityTypeList",iFacilityTypeRepository.findAll());
        model.addAttribute("rentTypeList",iRentTypeRepository.findAll());
        model.addAttribute("facilityObj",new Facility());
        return "list-facility-page";
    }

    @PostMapping("/delete/{id}")
    public String deleteFacility(@PathVariable("id") Integer id,
                                 RedirectAttributes redirectAttributes){
        if(!iFacilityService.existsById(id)){
            redirectAttributes.addFlashAttribute("mess","Xóa thất bại");
            return "redirect:/facility/list";
        }
        iFacilityService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/facility/list";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }


}