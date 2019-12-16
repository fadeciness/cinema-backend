package ru.rosbank.javaschool.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rosbank.javaschool.cinema.entity.FilmEntity;

public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {
}
