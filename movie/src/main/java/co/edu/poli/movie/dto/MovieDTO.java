package co.edu.poli.movie.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MovieDTO {

    @NotEmpty(message = "The title can not be empty")
    private String title;

    @NotEmpty(message = "The director can not be empty")
    private String director;

    @Min(value = 1, message = "The rating must be equal o greater that 1")
    @Max(value = 5, message = "The rating must be equal o smaller that 5")
    private int rating;
}
