package rikkei.academy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rikkei.academy.model.Song;

public interface ISongRepository extends PagingAndSortingRepository<Song, Long> {
}