package co.edu.poli.showtime.persistence.entity;

import co.edu.poli.showtime.model.Movie;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@Entity
@Table(name = "tbl_showtime")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ElementCollection
    private List<Long> moviesId;


    @Transient
    private List<Movie> movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Showtime showtime)) return false;
        return Objects.equals(getId(), showtime.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
