package mk.ukim.finki.wplab1.repository;

import mk.ukim.finki.wplab1.config.DataHolder;
import mk.ukim.finki.wplab1.model.Album;
import mk.ukim.finki.wplab1.model.Artist;
import mk.ukim.finki.wplab1.model.Song;
import mk.ukim.finki.wplab1.model.exception.InvalidSongException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class SongRepository {
    public List<Song> findAll(){
        return DataHolder.songs;
    };

    public Song findByTrackId(Long trackId){
        Song song = DataHolder.songs.stream()
                .filter(s -> s.getTrackId().equals(trackId))
                .findFirst().orElseThrow(InvalidSongException::new);
        return song;
    }

    public Artist addArtistToSong(Artist artist, Song song){
        song.addPerformer(artist);
        return artist;
    }

    public Optional<Song> save(String title, String genre, Integer releaseYear, Album album){
        Song song = new Song(title, genre, releaseYear, album);
        DataHolder.songs.removeIf(s -> Objects.equals(s.getTitle(), title));
        DataHolder.songs.add(song);
        return Optional.of(song);
    }

    public void deleteById(Long id) {
        DataHolder.songs.removeIf(s -> s.getTrackId().equals(id));
    }


//    public List<Artist> getAnArtist(Long aId){
//        Song song = DataHolder.songs.stream()
//                .filter(s -> s.getPerformers().stream()
//                        .filter(ar -> ar.getId().equals(aId))
//                        .toList())
//                .findFirst().orElseThrow(InvalidSongException::new);
//        List<Artist> as = song.getPerformers().stream()
//                .filter(a -> a.getId().equals(aId))
//                .toList();
//        return as;
//    }
}
