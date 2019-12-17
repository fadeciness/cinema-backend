package ru.rosbank.javaschool.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.entity.FilmEntity;
import ru.rosbank.javaschool.cinema.entity.TicketEntity;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionSaveRequestDto {

    private int id;
    private int hallNumber;
    private boolean type3D;
    private Date date;
    private int priceInRub;
    private FilmEntity filmEntity;
    private List<TicketEntity> tickets;
//    private int film_id;

}
