package co.edu.poli.booking.model;

import lombok.Data;

@Data
public class ShowtimeItem {
    private Long id;
    private Long movieId;
    private Movie movie;
}
