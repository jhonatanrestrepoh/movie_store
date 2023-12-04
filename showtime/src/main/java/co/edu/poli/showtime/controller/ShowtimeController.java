package co.edu.poli.showtime.controller;

import co.edu.poli.common.response.FormatResponse;
import co.edu.poli.common.response.Response;
import co.edu.poli.common.response.ResponseBuild;
import co.edu.poli.showtime.dto.ShowtimeDTO;
import co.edu.poli.showtime.dto.ShowtimeResponseDTO;
import co.edu.poli.showtime.service.ShowtimeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;

@RestController
@RequestMapping("/showtime")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;
    private final ResponseBuild build;
    private final FormatResponse formatResponse;

    @PostMapping
    public Response save(@Valid @RequestBody ShowtimeDTO showtimeDTO, BindingResult result) {

        if (result.hasErrors()) {
            return build.failed(formatResponse.format(result));
        }

        showtimeService.save(showtimeDTO);
        return build.success(showtimeDTO);
    }

    @GetMapping
    public Response findAllWithMovies(){
        return build.success(showtimeService.findAllWithMovies());
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable Long id){
        try {
            return build.success(showtimeService.findById(id));
        } catch (EntityNotFoundException exception){
            return build.failed("Showtime not found with id: " + id);
        }
    }

    @PutMapping("/{id}")
    public Response updateShowtime(@PathVariable Long id, @RequestBody ShowtimeDTO updatedShowtimeDTO) {
        try {
            return build.success(showtimeService.updateShowtime(id, updatedShowtimeDTO));
        } catch (EntityNotFoundException exception) {
            return build.failed(("Showtime not found with id: " + id));
        }
    }
}
