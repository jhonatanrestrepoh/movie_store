package co.edu.poli.booking.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Showtime {
    private Long id;
    private Date date;
    private List<ShowtimeItem> items;
}
