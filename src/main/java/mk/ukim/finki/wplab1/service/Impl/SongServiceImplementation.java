package mk.ukim.finki.wplab1.service.Impl;

import mk.ukim.finki.wplab1.model.Album;
import mk.ukim.finki.wplab1.model.Artist;
import mk.ukim.finki.wplab1.model.Song;
import mk.ukim.finki.wplab1.repository.SongRepository;
import mk.ukim.finki.wplab1.repository.jpa.SongRepositoryJpa;
import mk.ukim.finki.wplab1.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImplementation implements SongService {
    private final SongRepository songRepository;
    private final SongRepositoryJpa songRepositoryJpa;

    public SongServiceImplementation(SongRepository songRepository, SongRepositoryJpa songRepositoryJpa) {
        this.songRepository = songRepository;
        this.songRepositoryJpa = songRepositoryJpa;
    }

    @Override
    public List<Song> listSongs() {
        return this.songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return this.songRepository.addArtistToSong(artist, song);
    }

    @Override
    public Song findByTrackId(Long trackId) {
        Song s = this.songRepository.findByTrackId(trackId);
        return s;
    }

    @Override
    public Optional<Song> save(String title, String genre, Integer releaseYear, Album album) {
        return songRepository.save(title, genre, releaseYear, album);
    }

    @Override
    public void deleteById(Long id) {
        this.songRepository.deleteById(id);
    }

    @Override
    public List<Song> findAllByAlbumId(Long albumId) {
        return this.songRepositoryJpa.findAllByAlbum_Id(albumId);
    }


}
