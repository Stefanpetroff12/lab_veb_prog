package mk.ukim.finki.wplab1.service.Impl;

import mk.ukim.finki.wplab1.model.Album;
import mk.ukim.finki.wplab1.repository.AlbumRepository;
import mk.ukim.finki.wplab1.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImplementation implements AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumServiceImplementation(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Optional<Album> findById(Long albumId) {
        return albumRepository.findAlbumById(albumId);
    }

}
