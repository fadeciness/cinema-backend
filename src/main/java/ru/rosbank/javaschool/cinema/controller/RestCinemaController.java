package ru.rosbank.javaschool.cinema.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rosbank.javaschool.cinema.dto.FilmResponseDto;
import ru.rosbank.javaschool.cinema.dto.FilmSaveRequestDto;
import ru.rosbank.javaschool.cinema.dto.SessionResponseDto;
import ru.rosbank.javaschool.cinema.dto.SessionSaveRequestDto;
import ru.rosbank.javaschool.cinema.entity.Film;
import ru.rosbank.javaschool.cinema.entity.Session;
import ru.rosbank.javaschool.cinema.service.FilmService;
import ru.rosbank.javaschool.cinema.service.SessionAndTicketService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/films")
public class RestCinemaController {

    private final FilmService service;
    private final SessionAndTicketService sessionAndTicketService;

    @GetMapping
    public List<FilmResponseDto> getAllFilms() {
        return service.getAll();
    }

    @PostMapping
    public FilmResponseDto saveFilm(@RequestBody FilmSaveRequestDto dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void removeFilmById(@PathVariable int id) {
        service.removeById(id);
    }

    @GetMapping("/{id}/sessions")
    public List<SessionResponseDto> getAllSessions() {
        return sessionAndTicketService.getAll();
    }

    @PostMapping("/{id}/sessions")
    public SessionResponseDto saveSession(@RequestBody SessionSaveRequestDto dto) {
        dto.getFilm().addSession(Session.from(dto));
//        Film film = dto.getFilm();
//        film.addSession(Session.from(dto));
        service.save(dto.getFilm());
        return sessionAndTicketService.save(dto);
    }

    @DeleteMapping("/{id}/sessions/{id}")
    public void removeSessionById(@PathVariable int id) {
        sessionAndTicketService.removeById(id);
    }

}