package mk.ukim.finki.wplab1.service.Impl;

import mk.ukim.finki.wplab1.model.Artist;
import mk.ukim.finki.wplab1.model.Song;
import mk.ukim.finki.wplab1.model.exception.InvalidArtistException;
import mk.ukim.finki.wplab1.repository.ArtistRepository;
import mk.ukim.finki.wplab1.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImplementation implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImplementation(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return this.artistRepository.findAll();
    }

    @Override
    public Artist ArtistfindById(Long id) {
        Artist a = this.artistRepository.findById(id).orElseThrow(InvalidArtistException::new);
        return a;
    }

//    @Override
//    public List<Song> hisSongs(Long id) {
//        List<Song> ss = this.artistRepository.hisSongs(id);
//        return null;
//    }


}
