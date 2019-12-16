package ru.rosbank.javaschool.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rosbank.javaschool.cinema.entity.SessionEntity;

import java.util.List;

public interface SessionRepository extends JpaRepository<SessionEntity, Integer> {

    List<SessionEntity> findAllByFilmEntityId(int filmEntity_id);

}
