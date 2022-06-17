package program.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import program.model.Music;
import program.service.IMusicService;

@Controller
@RequestMapping("/music")
public class MusicController {


    @Autowired
    IMusicService iMusicService;


    @GetMapping("/form")
    public String getForm(ModelMap modelMap){
        modelMap.addAttribute("music",new Music());
        return "form-page";
    }

    @GetMapping("/list")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("list-music");
        modelAndView.addObject("listMusic",iMusicService.getListMusic());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public String detailMusic(@PathVariable Integer id,
                              Model model){
        model.addAttribute("music",iMusicService.getDetailMusic(id));
        return "detail-music";
    }

    @PostMapping("/add")
    public String addMusic(@ModelAttribute Music music,
                           RedirectAttributes redirectAttributes){
        music.setId((int) (Math.random()*1000));
        iMusicService.addMusicToList(music);
        redirectAttributes.addFlashAttribute("mess","Add thành công");
        return "redirect:/music/list";
    }
}
