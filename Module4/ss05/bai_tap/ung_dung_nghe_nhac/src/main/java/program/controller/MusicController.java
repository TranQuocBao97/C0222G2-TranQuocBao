package program.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import program.model.Music;
import program.service.IMusicService;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private IMusicService iMusicService;


    @GetMapping("/list")
    public String displayAllMusic(Model model) {
        List<Music> musicList = iMusicService.getAll();
        model.addAttribute("musicList", musicList);
        return "/list-music";
    }

    @GetMapping("/add-page")
    public String displayAddPage(Model model) {
        model.addAttribute("music", new Music());
        return "/add-music";
    }

    @PostMapping("/add")
    public String addNewMusic(Music music) {
        iMusicService.create(music);
        return "redirect:/music/list";
    }

    @GetMapping("/edit-page/{id}")
    public String displayEditPage(@PathVariable Integer id,
                                    Model model) {
        model.addAttribute("music",iMusicService.findMusicById(id));
        return "/edit-music";
    }

    @PostMapping("/edit")
    public String editMusic(Music music){
        iMusicService.update(music);
        return "redirect:/music/list";
    }

    @GetMapping("/delete/{id}")
    public String displayDeletePage(@PathVariable Integer id,
                                    RedirectAttributes redirectAttributes){
        iMusicService.delete(id);
        redirectAttributes.addAttribute("mess","deleted");
        return "redirect:/music/list";
    }



}
