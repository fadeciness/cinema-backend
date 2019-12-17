package ru.rosbank.javaschool.cinema.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.entity.SessionEntity;
import ru.rosbank.javaschool.cinema.enumeration.Genre;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api
public class FilmSaveRequestDto {

    @ApiModelProperty(position = 1)
    private int id;

    @ApiModelProperty(position = 2)
    private String title;

    @ApiModelProperty(position = 3)
    private String description;

    @ApiModelProperty(position = 4)
    private String image;

    @ApiModelProperty(position = 5)
    private String trailer;

    @ApiModelProperty(position = 6)
    private List<Genre> genres;

    @ApiModelProperty(position = 7)
    private List<SessionEntity> sessions;

}
