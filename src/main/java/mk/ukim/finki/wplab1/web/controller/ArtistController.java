package mk.ukim.finki.wplab1.web.controller;

import mk.ukim.finki.wplab1.model.Artist;
import mk.ukim.finki.wplab1.model.Song;
import mk.ukim.finki.wplab1.service.AlbumService;
import mk.ukim.finki.wplab1.service.ArtistService;
import mk.ukim.finki.wplab1.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ArtistController {
    private final SongService songService;
    private final AlbumService albumService;
    private final ArtistService artistService;

    public ArtistController(SongService songService, AlbumService albumService, ArtistService artistService) {
        this.songService = songService;
        this.albumService = albumService;
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    public String showArtists(@RequestParam(required = false) Long trackId,
                              @RequestParam(required = false) Long artistId,
                              Model model){
        if (trackId == null) {
            model.addAttribute("errorMessage", "Track ID is missing!");
            return "artistsList";
        }

        Song selectedSong = songService.findByTrackId(trackId);
        if (selectedSong == null) {
            model.addAttribute("errorMessage", "Song not found!");
            return "artistsList";
        }

        model.addAttribute("selectedSong", selectedSong);

        if (artistId != null) {
            Artist artist = artistService.ArtistfindById(artistId);
            if (artist != null) {
                selectedSong.addPerformer(artist);
            } else {
                model.addAttribute("errorMessage", "Artist not found!");
            }
        }

        model.addAttribute("trackId", trackId);
        model.addAttribute("allArtists", this.artistService.listArtists());
        return "artistsList";
    }

//    @GetMapping("/artists/selected")
//    public String tableArtists(@RequestParam(required = false) Long trackId,
//                               @RequestParam(required = false) Long artistId,
//                              Model model){
//        List<Artist> chosenArtists = new ArrayList<>();
//        Song s = this.songService.findByTrackId(trackId);
//        Artist a = this.artistService.ArtistfindById(artistId);
//        chosenArtists.add(a);
//        s.setPerformers(chosenArtists);
//        model.addAttribute("chosenArtists", s.getPerformers());
//        return "artistsList";
//    }
}
