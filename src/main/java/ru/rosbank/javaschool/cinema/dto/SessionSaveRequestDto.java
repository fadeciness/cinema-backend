package ru.rosbank.javaschool.cinema.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.constant.Errors;
import ru.rosbank.javaschool.cinema.constant.Sizes;
import ru.rosbank.javaschool.cinema.entity.FilmEntity;
import ru.rosbank.javaschool.cinema.entity.TicketEntity;

import javax.validation.constraints.Min;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api
public class SessionSaveRequestDto {

    @ApiModelProperty(position = 1)
    @Min(value = 0, message = Errors.MIN_VALUE)
    private int id;

    @ApiModelProperty(position = 2)
    @Min(value = Sizes.HALLS_COUNT, message = Errors.MIN_VALUE)
    private int hallNumber;

    @ApiModelProperty(position = 3)
    private boolean type3D;

    @ApiModelProperty(position = 4)
    @Min(value = 0, message = Errors.MIN_VALUE)
    private long date;

    @ApiModelProperty(position = 5)
    @Min(value = 0, message = Errors.MIN_VALUE)
    private int priceInRub;

    @ApiModelProperty(position = 6)
    private FilmEntity filmEntity;

    @ApiModelProperty(position = 7)
    private List<TicketEntity> tickets;

}
