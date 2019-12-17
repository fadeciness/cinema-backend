package ru.rosbank.javaschool.cinema.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.entity.FilmEntity;
import ru.rosbank.javaschool.cinema.entity.TicketEntity;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api
public class SessionSaveRequestDto {

    @ApiModelProperty(position = 1)
    private int id;

    @ApiModelProperty(position = 2)
    private int hallNumber;

    @ApiModelProperty(position = 3)
    private boolean type3D;

    @ApiModelProperty(position = 4)
    private long date;

    @ApiModelProperty(position = 5)
    private int priceInRub;

    @ApiModelProperty(position = 6)
    private FilmEntity filmEntity;

    @ApiModelProperty(position = 7)
    private List<TicketEntity> tickets;

}
