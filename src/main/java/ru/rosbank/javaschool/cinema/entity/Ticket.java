package ru.rosbank.javaschool.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.enumeration.SeatStatus;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int line;
    private int seat;
    private SeatStatus seatStatus;

    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    private Session session;

    public Ticket(int line, int seat, SeatStatus seatStatus, Session session) {
        this.line = line;
        this.seat = seat;
        this.seatStatus = seatStatus;
        this.session = session;
    }
}
