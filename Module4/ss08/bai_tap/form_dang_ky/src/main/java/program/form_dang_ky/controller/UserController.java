package program.form_dang_ky.controller;


import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import program.form_dang_ky.dto.UserDTO;
import program.form_dang_ky.model.User;
import program.form_dang_ky.service.IUserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;



    @GetMapping("/form")
    public String formPage(Model model){
        model.addAttribute("userDto",new UserDTO());
        return "form-page";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("userDto") @Valid UserDTO userDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model){
        if(bindingResult.hasErrors()){
            return "form-page";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        iUserService.saveUser(user);
        redirectAttributes.addFlashAttribute("mess","addSuccess");

        return "redirect:/user/form";
    }

}
