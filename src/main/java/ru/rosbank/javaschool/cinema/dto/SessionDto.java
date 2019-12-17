package ru.rosbank.javaschool.cinema.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.entity.SessionEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api
public class SessionDto {

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

    public static SessionDto from(SessionEntity model) {
        return new SessionDto(
                model.getId(),
                model.getHallNumber(),
                model.isType3D(),
                model.getDate(),
                model.getPriceInRub()
        );
    }

}
