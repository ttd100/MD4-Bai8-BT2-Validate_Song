package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rikkei.academy.model.Song;
import rikkei.academy.service.ISongService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class SongController {

    @Autowired
    private ISongService songService;

    @ModelAttribute("songList")
    public Iterable<Song> getSongList() {
        return songService.findAll();
    }

    @GetMapping("/")
    public String getHome(
            @ModelAttribute("song") Song song
    ) {
        return "/index";
    }

    @PostMapping("/")
    public String save(
            @Valid
            @ModelAttribute("song") Song song,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasFieldErrors()) {
            return "/index";
        }
        songService.save(song);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(
            @RequestParam("id")
            Optional<Song> song,
            Model model
    ) {
        model.addAttribute("songEdit", song.get());
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(
            @Valid
            @ModelAttribute("songEdit")
            Song song,
            BindingResult result
    ) {
        if (result.hasFieldErrors()) {
            return "/edit";
        }
        songService.save(song);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(
            @RequestParam("id")
            Optional<Song> song,
            Model model
    ) {
        model.addAttribute("songDelete", song.get());
        return "/delete";
    }

    @PostMapping("/delete")
    public String remove(
            Song song
    ) {
        songService.remove(song.getId());
        return "redirect:/";
    }
}