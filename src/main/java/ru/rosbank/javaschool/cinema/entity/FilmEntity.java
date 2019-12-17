package ru.rosbank.javaschool.cinema.entity;

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
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String image;
    private String trailer;

    @ElementCollection
    private List<Genre> genres;

    @OneToMany(
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER,
            mappedBy = "filmEntity"
    )
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
