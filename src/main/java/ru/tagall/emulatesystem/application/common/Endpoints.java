package ru.tagall.emulatesystem.application.common;

public interface Endpoints {
    public interface Session{
        String GET_ACTIVE_SESSIONS = "/session/{sessionType}";
        String GET_SESSION = "/session/{sessionId}";
        String NEW_BET = "/session/{sessionId}/bet";
    }
}
