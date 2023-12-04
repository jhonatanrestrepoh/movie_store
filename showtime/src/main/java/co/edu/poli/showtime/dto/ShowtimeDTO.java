package co.edu.poli.showtime.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ShowtimeDTO {

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @NotEmpty(message = "The movies can not be empty ")
    private List<Long> moviesId;
}
