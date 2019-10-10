package com.kat.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kat.lookify.models.Song;
import com.kat.lookify.services.SongService;

@Controller
public class SongController {
	@Autowired
    public SongService songService;
  
    
    @RequestMapping("/songs")
    public String index(Model model) {
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "/songs/index.jsp";
    }
    
    @RequestMapping(value="/songs", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "/songs/newSong.jsp";
        } else {
            songService.createSong(song);
            return "redirect:/songs";
        }
    }
    @RequestMapping("/songs/topsongs")
    public String topSongs(Model model) {
        List<Song> topSongs = songService.topRated();
        model.addAttribute("topSongs", topSongs);
        return "/songs/topSongs.jsp";
    }
    
    @RequestMapping("/songs/by")
    public String artistSongs(Model model, @RequestParam(value="artist", required=false) String name) {
        List<Song> artistSongs = songService.findByArtist(name);
        model.addAttribute("artistSongs", artistSongs);
        return "/songs/artistSongs.jsp";
    }
    
    @RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Song song) {
        return "/songs/newSong.jsp";
    }
    
    @Controller
    public class SongsController {
        // other methods removed for brevity
        @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
        public String destroy(@PathVariable("id") Long id) {
            songService.deleteSong(id);
            return "redirect:/songs";
        }
    }
   
}

