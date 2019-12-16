package ru.rosbank.javaschool.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rosbank.javaschool.cinema.entity.TicketEntity;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {

//    List<TicketEntity> findAllBySessionId(int session_id);
    List<TicketEntity> findAllBySessionEntity_Id(int session_id);
}
