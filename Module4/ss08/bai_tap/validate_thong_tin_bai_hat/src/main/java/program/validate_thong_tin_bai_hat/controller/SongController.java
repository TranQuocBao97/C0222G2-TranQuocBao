package program.validate_thong_tin_bai_hat.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import program.validate_thong_tin_bai_hat.dto.SongDTO;
import program.validate_thong_tin_bai_hat.model.Song;
import program.validate_thong_tin_bai_hat.service.ISongService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService iSongService;


    @GetMapping("/list")
    public String displayListSong(Model model) {
        List<Song> songList = iSongService.getAllSong();
        model.addAttribute("songList", songList);
        return "song-list";
    }

    @GetMapping("/form")
    public String displayAddFrom(Model model) {
        model.addAttribute("songDto", new SongDTO());
        return "song-add";
    }

    @PostMapping("/create")
    public String createNewSong(@ModelAttribute("songDto") @Valid SongDTO songDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "song-add";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        iSongService.addNewSong(song);
        return "redirect:/song/list";
    }

    @GetMapping("/edit-form/{id}")
    public String editPage(@PathVariable Integer id,
                           Model model){
        Song song = iSongService.getSongById(id);
        SongDTO songDto = new SongDTO();
        BeanUtils.copyProperties(song, songDto);
        model.addAttribute("songDto",songDto);
        return "song-edit";
    }

    @PostMapping("/edit")
    public String updateSong(@ModelAttribute("songDto") @Valid SongDTO songDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            return "song-edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        iSongService.addNewSong(song);
        return "redirect:/song/list";
    }

}
