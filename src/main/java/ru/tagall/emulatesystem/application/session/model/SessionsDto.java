package ru.tagall.emulatesystem.application.session.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
public class SessionsDto {
    private List<SessionDto> sessions;
}
