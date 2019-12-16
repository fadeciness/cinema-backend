package ru.rosbank.javaschool.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.entity.FilmEntity;
import ru.rosbank.javaschool.cinema.enumeration.Genre;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {

    private int id;
    private String title;
    private String description;
    private String image;
    private String trailer;
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
