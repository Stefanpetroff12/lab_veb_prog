package mk.ukim.finki.wplab1.repository.jpa;

import mk.ukim.finki.wplab1.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepositoryJpa extends JpaRepository<Song,Long> {
    List<Song> findAllByAlbum_Id(Long albumId);
}
