package ru.rosbank.javaschool.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.dto.SessionSaveRequestDto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int hallNumber;
    private boolean type3D;
    private Date date;
    private int priceInRub;

    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "id")
    private Film film;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "session"
    )
    private List<Ticket> tickets;

    public Session(int hallNumber, boolean type3D, Date date, int priceInRub, Film film, List<Ticket> tickets) {
        this.hallNumber = hallNumber;
        this.type3D = type3D;
        this.date = date;
        this.priceInRub = priceInRub;
        this.film = film;
        this.tickets = tickets;
    }

    public static Session from(SessionSaveRequestDto dto) {
        return new Session(
                dto.getId(),
                dto.getHallNumber(),
                dto.isType3D(),
                dto.getDate(),
                dto.getPriceInRub(),
                dto.getFilm(),
                null
        );
    }
}
