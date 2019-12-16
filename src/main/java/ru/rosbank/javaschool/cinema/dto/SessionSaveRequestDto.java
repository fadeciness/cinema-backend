package ru.rosbank.javaschool.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.entity.Film;
import ru.rosbank.javaschool.cinema.entity.Ticket;
import ru.rosbank.javaschool.cinema.enumeration.Genre;

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
    private Film film;

}
