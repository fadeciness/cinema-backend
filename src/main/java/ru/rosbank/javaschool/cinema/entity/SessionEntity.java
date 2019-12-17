package ru.rosbank.javaschool.cinema.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.dto.SessionSaveRequestDto;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Api
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "film_entity_id", referencedColumnName = "id")
    @ApiModelProperty(position = 6)
    private FilmEntity filmEntity;

    @OneToMany(
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER,
            mappedBy = "sessionEntity"
    )
    @ApiModelProperty(position = 7)
    private List<TicketEntity> ticketEntities;

    public static SessionEntity from(SessionSaveRequestDto dto) {
        return new SessionEntity(
                dto.getId(),
                dto.getHallNumber(),
                dto.isType3D(),
                dto.getDate(),
                dto.getPriceInRub(),
                dto.getFilmEntity(),
                dto.getTickets()
        );
    }
}
