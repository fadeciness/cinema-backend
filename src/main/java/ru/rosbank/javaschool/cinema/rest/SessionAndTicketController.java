package ru.rosbank.javaschool.cinema.rest;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rosbank.javaschool.cinema.dto.SessionDto;
import ru.rosbank.javaschool.cinema.dto.SessionSaveRequestDto;
import ru.rosbank.javaschool.cinema.dto.TicketDto;
import ru.rosbank.javaschool.cinema.service.SessionAndTicketService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sessions/{id}")
public class SessionAndTicketController {

    private final SessionAndTicketService sessionAndTicketService;

    @GetMapping
    @ApiOperation(value = "Возвращает список сеансов на данный фильм по его ID")
    public List<SessionDto> getSessionsByFilmId(@PathVariable int id) {
        return sessionAndTicketService.getSessionsByFilmId(id);
    }

    @PostMapping
    @ApiOperation(value = "Сохраняет запись о сеансе в репозиторий")
    public SessionDto saveSession(@Valid @RequestBody SessionSaveRequestDto dto) {
        return sessionAndTicketService.saveSession(dto);
    }

    @DeleteMapping("/{sessionId}")
    @ApiOperation(value = "Удаляет запись о сеансе по ID")
    public void removeSessionById(@PathVariable int sessionId) {
        sessionAndTicketService.removeSessionById(sessionId);
    }

    @GetMapping("/{sessionId}/tickets")
    @ApiOperation(value = "Возвращает список всех билетов на данный сеанс по его ID")
    public List<TicketDto> getAllTicketsBySessionId(@PathVariable int sessionId) {
        return sessionAndTicketService.getAllTicketsBySessionId(sessionId);
    }

    @DeleteMapping("/{sessionId}/tickets/{ticketId}")
    @ApiOperation(value = "Изменяет статус билета на \"Продано\"")
    public TicketDto reserveSeat(@PathVariable int ticketId) {
        return sessionAndTicketService.updateTicketStatusById(ticketId);
    }

}