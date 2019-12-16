package ru.rosbank.javaschool.cinema.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosbank.javaschool.cinema.dto.FilmDto;
import ru.rosbank.javaschool.cinema.dto.FilmSaveRequestDto;
import ru.rosbank.javaschool.cinema.entity.FilmEntity;
import ru.rosbank.javaschool.cinema.repository.FilmRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository repository;

    public List<FilmDto> getAll() {
        return repository.findAll().stream()
                .map(FilmDto::from)
                .collect(Collectors.toList());
    }

    public FilmDto save(FilmSaveRequestDto dto) {
        return FilmDto.from(repository.save(FilmEntity.from(dto)));
    }

    public void removeById(int id) {
        repository.deleteById(id);
    }

//    public FilmDto getById(int id) {
//        return FilmDto.from(repository.findById(id).orElseThrow(FilmNotFoundException::new));
//    }
//
//    public FilmResponseDto save(FilmEntity model) {
//        return FilmResponseDto.from(repository.save(model));
//    }


}
