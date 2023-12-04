package co.edu.poli.movie.service;

import co.edu.poli.movie.dto.MovieDTO;
import co.edu.poli.movie.persistence.entity.Movie;

import java.util.List;

public interface MovieService {

    Movie save(MovieDTO movieDTO);
    void delete(Long id);
    Movie findById(Long id);
    List<Movie> findAll();
    List<Movie> getMoviesByIds(List<Long> ids);
}
