package ru.rosbank.javaschool.cinema.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.constant.Errors;
import ru.rosbank.javaschool.cinema.entity.SessionEntity;
import ru.rosbank.javaschool.cinema.enumeration.Genre;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api
public class FilmSaveRequestDto {

    @ApiModelProperty(position = 1)
    @Min(value = 0, message = Errors.MIN_VALUE_FILM_ID)
    private int id;

    @ApiModelProperty(position = 2)
    @NotNull(message = Errors.NULL_VALUE_FILM_TITLE)
    @Size(min = 1, message = Errors.MIN_VALUE_FILM_TITLE)
    @Size(max = 254, message = Errors.MAX_VALUE_FILM_TITLE)
    private String title;

    @ApiModelProperty(position = 3)
    @NotNull(message = Errors.NULL_VALUE_FILM_DESCRIPTION)
    @Size(max = 254, message = Errors.MAX_VALUE_FILM_DESCRIPTION)
    private String description;

    @ApiModelProperty(position = 4)
    private String image;

    @ApiModelProperty(position = 5)
    private String trailer;

    @ApiModelProperty(position = 6)
    @NotNull(message = Errors.NULL_VALUE_GENRES_LIST)
    @NotEmpty(message = Errors.EMPTY_VALUE_GENRES_LIST)
    private List<Genre> genres;

    @ApiModelProperty(position = 7)
    private List<SessionEntity> sessions;

}
