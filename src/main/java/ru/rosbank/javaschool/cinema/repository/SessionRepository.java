package ru.rosbank.javaschool.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rosbank.javaschool.cinema.entity.Session;

public interface SessionRepository extends JpaRepository<Session, Integer> {
}
