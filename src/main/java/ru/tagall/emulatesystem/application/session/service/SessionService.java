package ru.tagall.emulatesystem.application.session.service;

import org.springframework.web.bind.annotation.PathVariable;
import ru.tagall.emulatesystem.application.session.model.SessionsDto;

public interface SessionService {
    SessionsDto getSessionByType(String sessionType);

    SessionsDto getSessionById(Long sessionId);

    void betToSession(Long sessionId);
}
