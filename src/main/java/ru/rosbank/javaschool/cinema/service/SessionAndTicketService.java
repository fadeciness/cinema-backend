package ru.rosbank.javaschool.cinema.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosbank.javaschool.cinema.constant.Sizes;
import ru.rosbank.javaschool.cinema.dto.SessionDto;
import ru.rosbank.javaschool.cinema.dto.SessionSaveRequestDto;
import ru.rosbank.javaschool.cinema.dto.TicketDto;
import ru.rosbank.javaschool.cinema.entity.SessionEntity;
import ru.rosbank.javaschool.cinema.entity.TicketEntity;
import ru.rosbank.javaschool.cinema.enumeration.SeatStatus;
import ru.rosbank.javaschool.cinema.exception.SessionNotFoundException;
import ru.rosbank.javaschool.cinema.exception.TicketNotFoundException;
import ru.rosbank.javaschool.cinema.repository.SessionRepository;
import ru.rosbank.javaschool.cinema.repository.TicketRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SessionAndTicketService {

    private final SessionRepository sessionRepository;
    private final TicketRepository ticketRepository;

    public List<SessionDto> getSessionsByFilmId(int id) {
        return sessionRepository.findAllByFilmEntityId(id).stream()
                .map(SessionDto::from)
                .collect(Collectors.toList());
    }

    public SessionDto saveSession(SessionSaveRequestDto dto) {
        SessionEntity sessionEntity = sessionRepository.save(SessionEntity.from(dto));
        if (dto.getId() == 0) {
            for (int line = 1; line <= Sizes.LINES; line++) {
                for (int seat = 1; seat <= Sizes.SEATS_IN_LINE; seat++) {
                    TicketEntity ticketEntity = new TicketEntity(
                            0,
                            line,
                            seat,
                            SeatStatus.FREE,
                            sessionEntity
                    );
                    ticketRepository.save(ticketEntity);
                }
            }
        }
        return SessionDto.from(sessionEntity);
    }

    public void removeSessionById(int id) {
        sessionRepository.deleteById(id);
    }

    public List<TicketDto> getAllTicketsBySessionId(int id) {
        Optional<SessionEntity> session = sessionRepository.findById(id);
        if(session.isPresent()) {
            return ticketRepository.findAllBySessionEntity_Id(id).stream()
                    .map(TicketDto::from)
                    .collect(Collectors.toList());
        }
        throw new SessionNotFoundException();
    }

    public TicketDto updateTicketStatusById(int id) {
        TicketEntity ticketEntity = ticketRepository.findById(id).orElseThrow(TicketNotFoundException::new);
        ticketEntity.setSeatStatus(SeatStatus.TAKEN);
        return TicketDto.from(ticketRepository.save(ticketEntity));
    }
}
