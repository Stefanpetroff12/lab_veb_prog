package mk.ukim.finki.wplab1.service;

import mk.ukim.finki.wplab1.model.Album;
import mk.ukim.finki.wplab1.model.Artist;
import mk.ukim.finki.wplab1.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findByTrackId(Long trackId);
    public Optional<Song> save(String title, String genre, Integer releaseYear, Album album);
    void deleteById(Long id);

    List<Song> findAllByAlbumId (Long albumId);
}
