package mk.ukim.finki.wplab1.repository;

import mk.ukim.finki.wplab1.config.DataHolder;
import mk.ukim.finki.wplab1.model.Artist;
import mk.ukim.finki.wplab1.model.Song;
import mk.ukim.finki.wplab1.model.exception.InvalidArtistException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {
    public List<Artist> findAll(){
        return DataHolder.artists;
    }
    public Optional<Artist> findById(Long id){
        return DataHolder.artists.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }

//    public List<Song> hisSongs(Long id){
//        Artist a = DataHolder.artists.stream()
//                .filter(b -> b.getId().equals(id))
//                .findFirst().orElseThrow(InvalidArtistException::new);
//        return null;
//    };
}
