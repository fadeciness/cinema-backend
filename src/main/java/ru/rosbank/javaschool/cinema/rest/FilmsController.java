package ru.rosbank.javaschool.cinema.rest;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rosbank.javaschool.cinema.dto.FilmDto;
import ru.rosbank.javaschool.cinema.dto.FilmSaveRequestDto;
import ru.rosbank.javaschool.cinema.service.FilmService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/films")
public class FilmsController {

    private final FilmService filmService;

    @GetMapping
    @ApiOperation(value = "Возвращает список всех фильмов")
    public List<FilmDto> getAll() {
        return filmService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Осуществляет поиск фильма по ID")
    public FilmDto getById(@PathVariable int id) {
        return filmService.getById(id);
    }

    @PostMapping
    @ApiOperation(value = "Сохраняет запись о фильме в репозиторий")
    public FilmDto save(@Valid @RequestBody FilmSaveRequestDto dto) {
        return filmService.save(dto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет запись о фильме по ID")
    public void removeFilmById(@PathVariable int id) {
        filmService.removeById(id);
    }

}