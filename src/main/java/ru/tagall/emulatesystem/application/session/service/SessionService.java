package ru.tagall.emulatesystem.application.session.service;

import ru.tagall.emulatesystem.application.session.model.SessionDto;
import ru.tagall.emulatesystem.application.session.model.SessionsDto;

public interface SessionService {
    SessionsDto getSessionByType(String sessionType);

    SessionDto getSessionById(Long sessionId);

    void betToSession(Long sessionId);
}
