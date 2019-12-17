package ru.rosbank.javaschool.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.entity.TicketEntity;
import ru.rosbank.javaschool.cinema.enumeration.SeatStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketDto {

    private int id;
    private int line;
    private int seat;
    private SeatStatus seatStatus;

    public static TicketDto from(TicketEntity model) {
        return new TicketDto(
                model.getId(),
                model.getLine(),
                model.getSeat(),
                model.getSeatStatus()
        );
    }

}
