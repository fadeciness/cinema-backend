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
    private int priceInRub;
    private SeatStatus seatStatus;

    @ManyToOne
    private Session session;

    public Ticket(int line, int seat, int priceInRub, SeatStatus seatStatus, Session session) {
        this.line = line;
        this.seat = seat;
        this.priceInRub = priceInRub;
        this.seatStatus = seatStatus;
        this.session = session;
    }
}
