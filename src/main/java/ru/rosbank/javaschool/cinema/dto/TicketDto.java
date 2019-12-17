package ru.rosbank.javaschool.cinema.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.entity.TicketEntity;
import ru.rosbank.javaschool.cinema.enumeration.SeatStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Api
public class TicketDto {

    @ApiModelProperty(position = 1)
    private int id;

    @ApiModelProperty(position = 2)
    private int line;

    @ApiModelProperty(position = 3)
    private int seat;

    @ApiModelProperty(position = 4)
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
