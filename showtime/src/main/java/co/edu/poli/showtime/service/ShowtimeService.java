package co.edu.poli.showtime.service;

import co.edu.poli.showtime.dto.ShowtimeDTO;
import co.edu.poli.showtime.dto.ShowtimeResponseDTO;
import co.edu.poli.showtime.persistence.entity.Showtime;

import java.util.List;

public interface ShowtimeService {
    void save(ShowtimeDTO showtimeDTO);

    List<ShowtimeResponseDTO> findAllWithMovies();

    ShowtimeResponseDTO findById(Long id);

    Showtime updateShowtime(Long id, ShowtimeDTO updatedShowtimeDTO);
}
