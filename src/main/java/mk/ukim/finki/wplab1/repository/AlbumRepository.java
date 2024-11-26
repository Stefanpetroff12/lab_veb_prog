package mk.ukim.finki.wplab1.repository;

import mk.ukim.finki.wplab1.config.DataHolder;
import mk.ukim.finki.wplab1.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlbumRepository {

    public List<Album> findAll(){
        return DataHolder.albums;
    }

    public Optional<Album> findAlbumById(Long albumId) {
        return DataHolder.albums.stream().filter(a -> a.getId().equals(albumId)).findFirst();
    }
}
