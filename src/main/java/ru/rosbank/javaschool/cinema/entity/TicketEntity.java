package ru.rosbank.javaschool.cinema.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.enumeration.SeatStatus;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Api
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(position = 1)
    private int id;

    @ApiModelProperty(position = 2)
    private int line;

    @ApiModelProperty(position = 3)
    private int seat;

    @ApiModelProperty(position = 4)
    private SeatStatus seatStatus;

    @ManyToOne
    @JoinColumn(name = "session_entity_id", referencedColumnName = "id")
    @ApiModelProperty(position = 5)
    private SessionEntity sessionEntity;

}
