package ru.rosbank.javaschool.cinema.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.rosbank.javaschool.cinema.dto.FilmDto;
import ru.rosbank.javaschool.cinema.dto.FilmSaveRequestDto;
import ru.rosbank.javaschool.cinema.entity.FilmEntity;
import ru.rosbank.javaschool.cinema.exception.FilmNotFoundException;
import ru.rosbank.javaschool.cinema.repository.FilmRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class FilmServiceTest {

    private FilmRepository filmRepository;
    private FilmService service;

    @BeforeEach
    void setUp() {
        filmRepository = mock(FilmRepository.class);
        service = new FilmService(filmRepository);
    }

    @Test
    void getAllReturnEmptyListWhenRepoIsEmpty() {
        doReturn(Collections.emptyList()).when(filmRepository).findAll();

        List<FilmDto> result = service.getAll();

        assertTrue(result.isEmpty());
    }

    @Test
    void getAllReturnFilmDtoWhenEntityPresentInRepo() {
        FilmEntity entity = new FilmEntity();
        int countElements = 1;
        doReturn(List.of(entity)).when(filmRepository).findAll();

        List<FilmDto> result = service.getAll();

        assertEquals(FilmDto.from(entity), result.get(0));
        assertEquals(countElements, result.size());
    }

    @Test
    void saveReturnFilmDtoWhenFilmSaveRequestDtoWasSuccessfulSaved() {
        FilmSaveRequestDto saveRequestDto = new FilmSaveRequestDto();
        doReturn(FilmEntity.from(saveRequestDto)).when(filmRepository).save(FilmEntity.from(saveRequestDto));

        FilmDto result = service.save(saveRequestDto);

        assertEquals(FilmDto.from(FilmEntity.from(saveRequestDto)), result);
    }

    @Test
    void removeByIdDoesNotThrowWhenInputAnyId() {
        int id = 1;
        doNothing().when(filmRepository).deleteById(anyInt());

        assertDoesNotThrow(() -> service.removeById(id));
    }

    @Test
    void getByIdReturnFilmDtoWhenFilmEntityIsPresentInRepo() {
        int id = 1;
        FilmEntity entity = new FilmEntity();
        doReturn(Optional.of(entity)).when(filmRepository).findById(id);

        FilmDto result = service.getById(id);

        assertEquals(FilmDto.from(entity), result);
    }

    @Test
    void getByIdThrowExceptionWhenNoFilmWithSuchId() {
        int id = 1;
        doReturn(Optional.empty()).when(filmRepository).findById(id);

        assertThrows(FilmNotFoundException.class, () -> service.getById(id));
    }
}