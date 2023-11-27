package co.edu.poli.booking.persistence.entity;

import co.edu.poli.booking.model.Showtime;
import co.edu.poli.booking.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Transient
    private User user;

    @Column(name = "showtime_id")
    private Long showtimeId;

    @Transient
    private Showtime showtime;

    /*preguntar como poner aqui la lista de movies*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking booking)) return false;
        return Objects.equals(getId(), booking.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
