package co.edu.poli.movie.service;

import co.edu.poli.movie.dto.MovieDTO;
import co.edu.poli.movie.mapper.MovieDTOtoMovie;
import co.edu.poli.movie.persistence.entity.Movie;
import co.edu.poli.movie.persistence.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;
    private final MovieDTOtoMovie movieDTOtoMovie;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Movie save(MovieDTO movieDTO) {
        return movieRepository.save(movieDTOtoMovie.mapper(movieDTO));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Movie movie = findById(id);
        movieRepository.delete(movie);
    }

    @Override
    @Transactional(readOnly = true)
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
