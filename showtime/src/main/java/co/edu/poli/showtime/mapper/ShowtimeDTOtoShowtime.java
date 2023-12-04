package co.edu.poli.showtime.mapper;

import co.edu.poli.common.mapper.IMapper;
import co.edu.poli.showtime.dto.ShowtimeDTO;
import co.edu.poli.showtime.persistence.entity.Showtime;
import org.springframework.stereotype.Component;

@Component
public class ShowtimeDTOtoShowtime implements IMapper<ShowtimeDTO, Showtime> {
    @Override
    public Showtime mapper(ShowtimeDTO in) {
        Showtime showtime = new Showtime();
        showtime.setDate(in.getDate());
        showtime.setMoviesId(in.getMoviesId());
        return showtime;
    }
}
