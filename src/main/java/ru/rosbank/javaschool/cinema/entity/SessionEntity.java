package ru.rosbank.javaschool.cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.dto.SessionSaveRequestDto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int hallNumber;
    private boolean type3D;
    private Date date;
    private int priceInRub;

    @ManyToOne
    @JoinColumn(name = "film_entity_id", referencedColumnName = "id")
    private FilmEntity filmEntity;

    @OneToMany(
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER,
            mappedBy = "sessionEntity"
    )
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
