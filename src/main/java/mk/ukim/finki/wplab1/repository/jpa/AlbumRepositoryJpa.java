package mk.ukim.finki.wplab1.repository.jpa;

import mk.ukim.finki.wplab1.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepositoryJpa extends JpaRepository<Album,Long> {
}
