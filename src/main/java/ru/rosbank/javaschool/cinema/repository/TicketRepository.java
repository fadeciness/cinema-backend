package ru.rosbank.javaschool.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rosbank.javaschool.cinema.entity.Session;
import ru.rosbank.javaschool.cinema.entity.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findAllBySession(Session session);
}
