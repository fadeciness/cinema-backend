package ru.rosbank.javaschool.cinema.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.dto.FilmSaveRequestDto;
import ru.rosbank.javaschool.cinema.enumeration.Genre;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Api
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ElementCollection
    @ApiModelProperty(position = 6)
    private List<Genre> genres;

    @OneToMany(
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER,
            mappedBy = "filmEntity"
    )
    @ApiModelProperty(position = 7)
    private List<SessionEntity> sessionEntities;

    public static FilmEntity from(FilmSaveRequestDto dto) {
        return new FilmEntity(
                dto.getId(),
                dto.getTitle(),
                dto.getDescription(),
                dto.getImage(),
                dto.getTrailer(),
                dto.getGenres(),
                dto.getSessions()
        );
    }

}
