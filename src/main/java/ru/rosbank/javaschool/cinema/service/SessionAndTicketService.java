package ru.rosbank.javaschool.cinema.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosbank.javaschool.cinema.constant.HallSize;
import ru.rosbank.javaschool.cinema.dto.SessionResponseDto;
import ru.rosbank.javaschool.cinema.dto.SessionSaveRequestDto;
import ru.rosbank.javaschool.cinema.entity.Session;
import ru.rosbank.javaschool.cinema.entity.Ticket;
import ru.rosbank.javaschool.cinema.enumeration.SeatStatus;
import ru.rosbank.javaschool.cinema.repository.SessionRepository;
import ru.rosbank.javaschool.cinema.repository.TicketRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SessionAndTicketService {

    private final SessionRepository sessionRepository;
    private final TicketRepository ticketRepository;

    public List<SessionResponseDto> getAll() {
        return sessionRepository.findAll().stream()
                .map(SessionResponseDto::from)
                .collect(Collectors.toList());
    }

    public SessionResponseDto save(SessionSaveRequestDto dto) {
        Session session = sessionRepository.save(Session.from(dto));
        for (int line = 1; line <= HallSize.LINES; line++) {
            for (int seat = 1; seat <= HallSize.SEATS_IN_LINE; seat++) {
                Ticket ticket = new Ticket(
                        0,
                        line,
                        seat,
                        SeatStatus.FREE,
                        session
                );
                ticketRepository.save(ticket);
            }
        }
        session.setTickets(ticketRepository.findAllBySession(session));
        return SessionResponseDto.from(session);
    }

    public void removeById(int id) {
        sessionRepository.deleteById(id);
    }

}
