package ru.tagall.emulatesystem.application.session.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> getAllByStatus(String status);
}
