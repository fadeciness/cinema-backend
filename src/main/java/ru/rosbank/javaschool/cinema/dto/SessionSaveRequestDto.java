package ru.rosbank.javaschool.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.entity.FilmEntity;

import java.util.Date;

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
//    private int film_id;

}
