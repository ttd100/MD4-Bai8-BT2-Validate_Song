package rikkei.academy.service;

import rikkei.academy.model.Song;

import java.util.Optional;

public interface ISongService {
    Iterable<Song> findAll();

    Optional<Song> findById(Long id);

    void save(Song song);

    void remove(Long id);
}