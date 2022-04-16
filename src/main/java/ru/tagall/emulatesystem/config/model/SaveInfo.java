package ru.tagall.emulatesystem.config.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class SaveInfo {
    private Long customerId;
}
