package mk.ukim.finki.wplab1.service;

import mk.ukim.finki.wplab1.model.Artist;
import mk.ukim.finki.wplab1.model.Song;

import java.util.List;

public interface ArtistService {
    List<Artist> listArtists();
    Artist ArtistfindById(Long id);
//    List<Song> hisSongs(Long id);
}
