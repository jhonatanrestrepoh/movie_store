package co.edu.poli.showtime.mapper;

import co.edu.poli.common.mapper.IMapper;
import co.edu.poli.showtime.dto.ShowtimeResponseDTO;
import co.edu.poli.showtime.persistence.entity.Showtime;
import org.springframework.stereotype.Component;

@Component
public class ShowtimeToShowtimeResponseDTO implements IMapper <Showtime, ShowtimeResponseDTO> {
    @Override
    public ShowtimeResponseDTO mapper(Showtime in) {
        ShowtimeResponseDTO showtimeResponseDTO = new ShowtimeResponseDTO();
        showtimeResponseDTO.setId(in.getId());
        showtimeResponseDTO.setDate(in.getDate());
        showtimeResponseDTO.setMovies(in.getMovies());
        return showtimeResponseDTO;
    }
}
