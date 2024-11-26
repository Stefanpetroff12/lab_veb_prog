package mk.ukim.finki.wplab1.service;

import mk.ukim.finki.wplab1.model.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    public List<Album> findAll();

    Optional<Album> findById(Long albumId);
}
