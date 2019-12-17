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
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int line;
    private int seat;
    private SeatStatus seatStatus;

//    @ManyToOne(cascade = CascadeType.REMOVE)
    @ManyToOne
    @JoinColumn(name = "session_entity_id", referencedColumnName = "id")
    private SessionEntity sessionEntity;

//    public TicketEntity(int line, int seat, SeatStatus seatStatus, SessionEntity sessionEntity) {
//        this.line = line;
//        this.seat = seat;
//        this.seatStatus = seatStatus;
//        this.sessionEntity = sessionEntity;
//    }
}
