package ru.rosbank.javaschool.cinema.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.rosbank.javaschool.cinema.dto.SessionDto;
import ru.rosbank.javaschool.cinema.dto.SessionSaveRequestDto;
import ru.rosbank.javaschool.cinema.dto.TicketDto;
import ru.rosbank.javaschool.cinema.entity.SessionEntity;
import ru.rosbank.javaschool.cinema.entity.TicketEntity;
import ru.rosbank.javaschool.cinema.enumeration.SeatStatus;
import ru.rosbank.javaschool.cinema.exception.FilmNotFoundException;
import ru.rosbank.javaschool.cinema.exception.SessionNotFoundException;
import ru.rosbank.javaschool.cinema.repository.SessionRepository;
import ru.rosbank.javaschool.cinema.repository.TicketRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class SessionAndTicketServiceTest {

    private SessionRepository sessionRepository;
    private TicketRepository ticketRepository;
    private SessionAndTicketService service;

    @BeforeEach
    void setUp() {
        sessionRepository = mock(SessionRepository.class);
        ticketRepository = mock(TicketRepository.class);
        service = new SessionAndTicketService(sessionRepository, ticketRepository);
    }

    @Test
    void getSessionsByFilmIdReturnEmptyListWhenRepoIsEmpty() {
        int id = anyInt();

        List<SessionDto> result = service.getSessionsByFilmId(id);

        assertTrue(result.isEmpty());
    }

    @Test
    void getSessionsByFilmIdReturnSessionDtoWhenSessionEntityPresentInRepo() {
        int id = 1;
        SessionEntity entity = new SessionEntity();
        doReturn(List.of(entity)).when(sessionRepository).findAllByFilmEntityId(id);

        List<SessionDto> result = service.getSessionsByFilmId(id);

        assertEquals(SessionDto.from(entity), result.get(0));
    }

    @Test
    void saveSessionReturnFilmDtoWhenSessionSaveRequestDtoWasSuccessfulSaved() {
        SessionSaveRequestDto saveRequestDto = new SessionSaveRequestDto();
        doReturn(SessionEntity.from(saveRequestDto)).when(sessionRepository).save(SessionEntity.from(saveRequestDto));

        SessionDto result = service.saveSession(saveRequestDto);

        assertEquals(SessionDto.from(SessionEntity.from(saveRequestDto)), result);
    }

    @Test
    void saveSessionReturnFilmDtoWhenSessionSaveRequestDtoWasSuccessfulUpdated() {
        SessionSaveRequestDto saveRequestDto = new SessionSaveRequestDto();
        saveRequestDto.setId(1);
        doReturn(SessionEntity.from(saveRequestDto)).when(sessionRepository).save(SessionEntity.from(saveRequestDto));

        SessionDto result = service.saveSession(saveRequestDto);

        assertEquals(SessionDto.from(SessionEntity.from(saveRequestDto)), result);
    }

    @Test
    void removeSessionByIdDoesNotThrowWhenInputAnyId() {
        int id = 1;
        doNothing().when(sessionRepository).deleteById(anyInt());

        assertDoesNotThrow(() -> service.removeSessionById(id));
    }

    @Test
    void getAllTicketsBySessionIdReturnEmptyListWhenRepoIsEmpty() {
        int id = 0;
        doReturn(Optional.of(new SessionEntity())).when(sessionRepository).findById(id);
        doReturn(Collections.emptyList()).when(ticketRepository).findAllBySessionEntity_Id(id);

        List<TicketDto> result = service.getAllTicketsBySessionId(id);

        assertTrue(result.isEmpty());
    }

    @Test
    void getAllTicketsBySessionIdThrowExceptionWhenNoSessionWithSuchIdInRepo() {
        int id = 0;
        doReturn(Optional.empty()).when(sessionRepository).findById(id);

        assertThrows(SessionNotFoundException.class, () -> service.getAllTicketsBySessionId(id));
    }

    @Test
    void updateTicketStatusByIdShouldSetTicketStatusTaken() {
        int id = 1;
        TicketEntity entity = new TicketEntity();
        doReturn(Optional.of(entity)).when(ticketRepository).findById(id);
        doReturn(entity).when(ticketRepository).save(entity);

        TicketDto ticketDto = service.updateTicketStatusById(id);

        assertEquals(SeatStatus.TAKEN, ticketDto.getSeatStatus());
    }

    @Test
    void updateTicketStatusByIdThrowsExceptionWhenNoSuchId() {
        int id = 0;
        doThrow(FilmNotFoundException.class).when(ticketRepository).findById(anyInt());
        doReturn(Optional.of(new TicketEntity())).when(ticketRepository).findById(1);

        assertThrows(FilmNotFoundException.class, () -> service.updateTicketStatusById(id));
    }
}