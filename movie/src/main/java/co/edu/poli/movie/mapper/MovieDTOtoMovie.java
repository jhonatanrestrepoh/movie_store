package co.edu.poli.movie.mapper;

import co.edu.poli.movie.dto.MovieDTO;
import co.edu.poli.movie.persistence.entity.Movie;
import co.edu.poli.common.mapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class MovieDTOtoMovie implements IMapper<MovieDTO, Movie>{

    @Override
    public Movie mapper(MovieDTO in) {
        Movie movie = new Movie();
        movie.setTitle(in.getTitle());
        movie.setDirector(in.getDirector());
        movie.setRating(in.getRating());
        return movie;
    }
}
