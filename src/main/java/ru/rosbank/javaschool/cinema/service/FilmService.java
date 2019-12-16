package ru.rosbank.javaschool.cinema.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosbank.javaschool.cinema.dto.FilmResponseDto;
import ru.rosbank.javaschool.cinema.dto.FilmSaveRequestDto;
import ru.rosbank.javaschool.cinema.entity.Film;
import ru.rosbank.javaschool.cinema.repository.FilmRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository repository;

    public List<FilmResponseDto> getAll() {
        return repository.findAll().stream()
                .map(FilmResponseDto::from)
                .collect(Collectors.toList());
    }

    public FilmResponseDto save(FilmSaveRequestDto dto) {
        return FilmResponseDto.from(repository.save(Film.from(dto)));
    }

    public FilmResponseDto save(Film model) {
        return FilmResponseDto.from(repository.save(model));
    }

    public void removeById(int id) {
        repository.deleteById(id);
    }


}
