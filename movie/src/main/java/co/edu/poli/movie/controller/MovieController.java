package co.edu.poli.movie.controller;

import co.edu.poli.movie.dto.MovieDTO;
import co.edu.poli.movie.persistence.entity.Movie;
import co.edu.poli.movie.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public void save(@Valid @RequestBody MovieDTO movieDTO){
        movieService.save(movieDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Movie movie = movieService.findById(id);
        movieService.delete(movie);

    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable Long id){
        return movieService.findById(id);
    }
    @GetMapping
    public List<Movie> findAll(){
        return movieService.findAll();
    }
}
