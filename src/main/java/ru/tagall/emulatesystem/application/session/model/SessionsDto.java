package ru.tagall.emulatesystem.application.session.model;

import lombok.Data;

import java.util.List;

@Data
public class SessionsDto {
    private List<SessionDto> sessions;
}
