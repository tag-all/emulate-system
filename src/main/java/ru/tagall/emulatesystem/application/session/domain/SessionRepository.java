package ru.tagall.emulatesystem.application.session.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface SessionRepository extends JpaRepository<Session, Long> {
}
