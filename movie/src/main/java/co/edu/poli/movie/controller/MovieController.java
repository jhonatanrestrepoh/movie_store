package co.edu.poli.movie.controller;

import co.edu.poli.common.response.Response;
import co.edu.poli.common.response.ResponseBuild;
import co.edu.poli.common.response.FormatResponse;

import co.edu.poli.movie.dto.MovieDTO;

import co.edu.poli.movie.service.MovieService;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ResponseBuild build;
    private final FormatResponse formatResponse;

    @PostMapping
    public Response save(@Valid @RequestBody MovieDTO movieDTO, BindingResult result) {

        if (result.hasErrors()) {
            return build.failed(formatResponse.format(result));
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

}
