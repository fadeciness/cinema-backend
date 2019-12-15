package ru.rosbank.javaschool.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    private Film film;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "session"
    )
    private List<Ticket> tickets;

    public Session(int hallNumber, boolean type3D, Date date, Film film, List<Ticket> tickets) {
        this.hallNumber = hallNumber;
        this.type3D = type3D;
        this.date = date;
        this.film = film;
        this.tickets = tickets;
    }
}
