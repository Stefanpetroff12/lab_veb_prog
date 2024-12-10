package mk.ukim.finki.wplab1.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wplab1.model.Album;
import mk.ukim.finki.wplab1.model.Artist;
import mk.ukim.finki.wplab1.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists = null;
    public static List<Song> songs = null;
    public static List<Album> albums = null;

    @PostConstruct
    public void init(){
        artists = new ArrayList<>();
        artists.add(new Artist("Michael", "Jackson", "Pop singer"));
        artists.add(new Artist("Lady", "Gaga", "Pop queen"));
        artists.add(new Artist("Nicki", "Minaj", "Rap queen"));
        artists.add(new Artist("Karol", "G", "Latin pop singer"));
        artists.add(new Artist("Seka", "Aleksic", "Serbian pop singer"));

        albums = new ArrayList<>();
        albums.add(new Album("album 1", "k-pop", "2014"));
        albums.add(new Album("album 2", "pop", "2004"));
        albums.add(new Album("album 3", "rapp", "2010"));
        albums.add(new Album("album 4", "techno", "1980"));
        albums.add(new Album("album 5", "rock", "2002"));

        List<Artist> artistsft = new ArrayList<>();
        songs = new ArrayList<>();
        songs.add(new Song("Tusa", "latin", 2019, albums.get(2)));
        songs.add(new Song("Posljedni ljet", "serbian", 2004, albums.get(0)));
        songs.add(new Song("Anaconda", "rap", 2018, albums.get(3)));
        songs.add(new Song("Telephone", "pop", 2010, albums.get(1)));
        songs.add(new Song("I'm legit", "rap", 2015, albums.get(4)));

        //songs.get(0).setPerformers(artists);
        songs.get(0).addPerformer(artists.get(0));

    }
}
