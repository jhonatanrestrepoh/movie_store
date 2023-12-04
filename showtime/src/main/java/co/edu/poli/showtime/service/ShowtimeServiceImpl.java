package co.edu.poli.showtime.service;

import co.edu.poli.showtime.clientFeign.MovieClient;
import co.edu.poli.showtime.dto.ShowtimeDTO;
import co.edu.poli.showtime.dto.ShowtimeResponseDTO;
import co.edu.poli.showtime.mapper.ShowtimeDTOtoShowtime;
import co.edu.poli.showtime.mapper.ShowtimeToShowtimeResponseDTO;
import co.edu.poli.showtime.model.Movie;
import co.edu.poli.showtime.persistence.entity.Showtime;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import co.edu.poli.showtime.persistence.repository.ShowtimeRepository;
import lombok.AllArgsConstructor;

import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService{

    private final ShowtimeRepository showtimeRepository;
    private final MovieClient movieClient;
    private final CircuitBreakerFactory cbFactory;
    private final ShowtimeDTOtoShowtime showtimeDTOtoShowtime;
    private final ShowtimeToShowtimeResponseDTO showtimeResponseDTO;

    @Override
    public void save(ShowtimeDTO showtimeDTO) {

        List<Long> movieIds = showtimeDTO.getMoviesId();

        List<Movie> movies = findExistingMoviesByIds(movieIds);

        List<Long> existingMovieIds = extractIdsFromMovies(movies);

        showtimeDTO.setMoviesId(existingMovieIds);

        showtimeRepository.save(showtimeDTOtoShowtime.mapper(showtimeDTO));

    }

    @Override
    public List<ShowtimeResponseDTO> findAllWithMovies() {
        List<Showtime> showtimes = showtimeRepository.findAll();


        for (Showtime showtime : showtimes) {
            List<Movie> movies = (List<Movie>) movieClient.getMoviesByIds(showtime.getMoviesId()).getData();
            showtime.setMovies(movies);
        }

        return showtimes.stream()
                .map(showtimeResponseDTO::mapper)
                .collect(Collectors.toList());
    }

    @Override
    public ShowtimeResponseDTO findById(Long id){
        Showtime showtime = showtimeRepository.findById(id).orElse(null);
        if (showtime != null) {
            List<Movie> movies = (List<Movie>) movieClient.getMoviesByIds(showtime.getMoviesId()).getData();
            showtime.setMovies(movies);
            return showtimeResponseDTO.mapper(showtime);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Showtime updateShowtime(Long id, ShowtimeDTO updatedShowtimeDTO) {
        Showtime existingShowtime = showtimeRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        existingShowtime.setDate(updatedShowtimeDTO.getDate());

        List<Long> movieIds = updatedShowtimeDTO.getMoviesId();

        List<Movie> movies = findExistingMoviesByIds(movieIds);

        List<Long> existingMovieIds = extractIdsFromMovies(movies);

        existingShowtime.setMoviesId(existingMovieIds);

        return showtimeRepository.save(existingShowtime);
    }

    public Movie findMovieById(Long id){
        ModelMapper modelMapper = new ModelMapper();
        return cbFactory.create("findMovieById")
                .run(()->modelMapper.map(movieClient.findById(id).getData(),Movie.class),
                        e-> new Movie()  );
    }

    public List<Movie> findExistingMoviesByIds(List<Long> movieIds){
        return movieIds.stream()
                .map(this::findMovieById)
                .filter(Objects::nonNull)
                .toList();
    }

    public List<Long> extractIdsFromMovies(List<Movie> movies) {
        return movies.stream()
                .map(Movie::getId)
                .collect(Collectors.toList());
    }
}
