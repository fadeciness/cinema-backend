package ru.rosbank.javaschool.cinema.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rosbank.javaschool.cinema.dto.FilmDto;
import ru.rosbank.javaschool.cinema.dto.FilmSaveRequestDto;
import ru.rosbank.javaschool.cinema.service.FilmService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/films")
public class FilmsController {

    private final FilmService filmService;

    @GetMapping
    public List<FilmDto> getAll() {
        return filmService.getAll();
    }

    @PostMapping
    public FilmDto save(@RequestBody FilmSaveRequestDto dto) {
        return filmService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void removeFilmById(@PathVariable int id) {
        filmService.removeById(id);
    }

}