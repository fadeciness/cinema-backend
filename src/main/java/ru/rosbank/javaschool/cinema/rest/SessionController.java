package ru.rosbank.javaschool.cinema.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rosbank.javaschool.cinema.dto.*;
import ru.rosbank.javaschool.cinema.entity.TicketEntity;
import ru.rosbank.javaschool.cinema.service.SessionAndTicketService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sessions")
public class SessionController {

    private final SessionAndTicketService sessionAndTicketService;

//    @GetMapping
//    public List<SessionDto> getAll() {
//        return sessionAndTicketService.getAllSessions();
//    }

    @GetMapping("/{id}")
    public List<SessionDto> getSessionsByFilmId(@PathVariable int id) {
        return sessionAndTicketService.getSessionsByFilmId(id);
    }

    @PostMapping("/{id}")
    public SessionDto saveSession(@RequestBody SessionSaveRequestDto dto) {
        return sessionAndTicketService.saveSession(dto);
    }

    @DeleteMapping("/{id}/{session_id}")
    public void removeSessionById(@PathVariable(name = "session_id") int id) {
        sessionAndTicketService.removeSessionById(id);
    }

    @GetMapping("/{id}/{session_id}/tickets")
    public List<TicketEntity> getAllTicketsBySessionId(@PathVariable(name = "session_id") int id) {
        return sessionAndTicketService.getAllTicketsBySessionId(id);
    }

    @PostMapping("/{id}/{session_id}/tickets/{ticket_id}")
    public TicketEntity reserveSeat(@PathVariable(name = "ticket_id") int id) {
        return sessionAndTicketService.updateTicketStatusById(id);
    }

}