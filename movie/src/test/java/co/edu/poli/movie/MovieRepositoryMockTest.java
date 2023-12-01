package co.edu.poli.movie;

import co.edu.poli.movie.persistence.entity.Movie;
import co.edu.poli.movie.persistence.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class MovieRepositoryMockTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    @Transactional
    public void testSaveMovie() {

        Movie movie = new Movie();
        movie.setTitle("Avengers");
        movie.setDirector("Joss Whedon");
        movie.setRating(5);

        movieRepository.save(movie);

        Movie savedMovie = movieRepository.findById(movie.getId()).orElse(null);

        assertNotNull(savedMovie);
        assertEquals(movie.getTitle(), savedMovie.getTitle());
        assertEquals(movie.getDirector(), savedMovie.getDirector());
        assertEquals(movie.getRating(), savedMovie.getRating());

    }
}
