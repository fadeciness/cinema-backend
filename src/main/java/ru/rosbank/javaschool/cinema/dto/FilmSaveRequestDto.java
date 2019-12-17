package ru.rosbank.javaschool.cinema.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.entity.SessionEntity;
import ru.rosbank.javaschool.cinema.enumeration.Genre;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api
public class FilmSaveRequestDto {

    @ApiModelProperty(position = 1)
    @Min(value = 0, message = "error.validation.value.id_film")
    private int id;

    @ApiModelProperty(position = 2)
    @NotNull(message = "error.validation.null.title_film")
    private String title;

    @ApiModelProperty(position = 3)
    @NotNull(message = "error.validation.null.description_film")
    private String description;

    @ApiModelProperty(position = 4)
    @NotNull(message = "error.validation.null.image_film")
    private String image;

    @ApiModelProperty(position = 5)
    @NotNull(message = "error.validation.null.trailer_film")
    private String trailer;

    @ApiModelProperty(position = 6)
    private List<Genre> genres;

    @ApiModelProperty(position = 7)
    private List<SessionEntity> sessions;

}
