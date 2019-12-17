package ru.rosbank.javaschool.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.rosbank.javaschool.cinema.entity.SessionEntity;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SessionDto {

    private int id;
    private int hallNumber;
    private boolean type3D;
    private Date date;
    private int priceInRub;

    public static SessionDto from(SessionEntity model) {
        return new SessionDto(
                model.getId(),
                model.getHallNumber(),
                model.isType3D(),
                model.getDate(),
                model.getPriceInRub()
        );
    }

}
