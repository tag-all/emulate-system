package ru.tagall.emulatesystem.error;

import lombok.Getter;
import ru.tagall.emulatesystem.error.model.ApplicationErrorDto;

/**
 * Ошибки приложения.
 *
 * @author Iurii Babalin.
 */
@Getter
public class ApplicationException extends RuntimeException {
    /**
     * {@link ApplicationErrorDto}.
     */
    private final ApplicationErrorDto error;

    public ApplicationException(ApplicationErrorDto error) {
        super(error.getMessage());
        this.error = error;
    }

    public ApplicationException(ApplicationErrorDto error, Throwable throwable) {
        super(error.getMessage(), throwable);
        this.error = error;
    }
}
