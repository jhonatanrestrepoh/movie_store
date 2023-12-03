package co.edu.poli.movie.controller;

import co.edu.poli.common.response.Response;
import co.edu.poli.common.response.ResponseBuild;
import co.edu.poli.movie.dto.MovieDTO;
import co.edu.poli.movie.persistence.entity.Movie;
import co.edu.poli.movie.service.MovieService;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ResponseBuild build;

    @PostMapping
    public Response save(@Valid @RequestBody MovieDTO movieDTO, BindingResult result) {

        if (result.hasErrors()) {
            return build.failed(format(result));
        }

        movieService.save(movieDTO);
        return build.success(movieDTO);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable Long id) {
        try {

            movieService.delete(id);
            return build.success("Deleted movie");

        } catch (InvalidDataAccessApiUsageException e) {

            return build.failed("Movie not found for ID: " + id);
        }

    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable Long id) {
        return build.success(movieService.findById(id));
    }

    @GetMapping
    public Response findAll() {
        return build.success(movieService.findAll());
    }

    private List<Map<String, String>> format(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream().map(error -> {
            Map<String, String> err = new HashMap<>();
            err.put(error.getField(), error.getDefaultMessage());
            return err;
        }).collect(Collectors.toList());
        return errors;
    }
}
