package ru.rosbank.javaschool.cinema.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.entity.FilmEntity;
import ru.rosbank.javaschool.cinema.enumeration.Genre;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class FilmDto {

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

    public static FilmDto from(FilmEntity model) {
        return new FilmDto(
                model.getId(),
                model.getTitle(),
                model.getDescription(),
                model.getImage(),
                model.getTrailer(),
                model.getGenres()
        );
    }

}
