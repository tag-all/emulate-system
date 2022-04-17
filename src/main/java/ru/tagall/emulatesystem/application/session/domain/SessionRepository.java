package ru.tagall.emulatesystem.application.session.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> getAllByStatus(String status);

    @Query(value = "update session set status = ?1 where id = ?2 returning id", nativeQuery = true)
    void setNewStatus(String status, Long sessionId);
}
