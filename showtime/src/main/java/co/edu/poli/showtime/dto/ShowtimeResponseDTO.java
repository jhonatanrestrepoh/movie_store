package co.edu.poli.showtime.dto;

import co.edu.poli.showtime.model.Movie;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ShowtimeResponseDTO {

    private Long id;
    private Date date;
    private List<Movie> movies;
}
