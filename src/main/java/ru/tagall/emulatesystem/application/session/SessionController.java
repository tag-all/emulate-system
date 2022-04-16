package ru.tagall.emulatesystem.application.session;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tagall.emulatesystem.application.common.Endpoints;
import ru.tagall.emulatesystem.application.session.model.SessionDto;
import ru.tagall.emulatesystem.application.session.model.SessionsDto;
import ru.tagall.emulatesystem.application.session.service.SessionService;

@RestController
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @GetMapping(Endpoints.Session.GET_SESSIONS)
    public SessionsDto getSessionByType(@PathVariable String sessionType){
        return sessionService.getSessionByType(sessionType);
    }

    @GetMapping(Endpoints.Session.GET_SESSION)
    public SessionDto getSessionById(@PathVariable Long sessionId){
        return sessionService.getSessionById(sessionId);
    }

    @PostMapping(Endpoints.Session.NEW_BET)
    public void betToSession(@PathVariable Long sessionId){
        sessionService.betToSession(sessionId);
    }
}
