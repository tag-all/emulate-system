package ru.tagall.emulatesystem.application.session.service.Impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.tagall.emulatesystem.application.session.model.SessionsDto;
import ru.tagall.emulatesystem.application.session.service.SessionService;

@Service
@AllArgsConstructor
@Slf4j
public class SessionServiceImpl implements SessionService {
    @Override
    public SessionsDto getSessionByType(String sessionType) {
        return null;
    }

    @Override
    public SessionsDto getSessionById(Long sessionId) {
        return null;
    }

    @Override
    public void betToSession(Long sessionId) {

    }
}
