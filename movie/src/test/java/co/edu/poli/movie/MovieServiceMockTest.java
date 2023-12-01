package co.edu.poli.movie;

import co.edu.poli.movie.mapper.MovieDTOtoMovie;
import co.edu.poli.movie.persistence.entity.Movie;
import co.edu.poli.movie.persistence.repository.MovieRepository;
import co.edu.poli.movie.service.MovieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MovieServiceMockTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private MovieDTOtoMovie movieDTOtoMovie;

    @InjectMocks
    private MovieServiceImpl movieService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        movieService = new MovieServiceImpl(movieRepository, movieDTOtoMovie);

        Movie movie = new Movie();
        movie.setTitle("Avengers");
        movie.setDirector("Joss Whedon");
        movie.setRating(5);

        Mockito.when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));
    }

    @Test
    public void whenValidGetID_ThenReturnMovie() {
        Movie foundMovie= movieService.findById(1L);
        assertEquals("Avengers", foundMovie.getTitle());
    }
}
