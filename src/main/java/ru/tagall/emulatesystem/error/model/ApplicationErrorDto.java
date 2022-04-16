package ru.tagall.emulatesystem.error.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.tagall.emulatesystem.error.ErrorType;

import java.time.LocalDateTime;

/**
 * Модель ошибки.
 *
 * @author Iurii Babalin.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class ApplicationErrorDto {
    private ErrorType type;
    private String code;
    @Schema(description = "Ошибка, текст для отображения пользователю")
    private String message;
    @Schema(description = "Время ошибки")
    private LocalDateTime time;

    public static ApplicationErrorDto of(ErrorType type, String code, String message) {
        return of(type, code, message, LocalDateTime.now());
    }
}
