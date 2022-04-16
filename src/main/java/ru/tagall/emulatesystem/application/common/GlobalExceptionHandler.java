package ru.tagall.emulatesystem.application.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.tagall.emulatesystem.error.ApplicationException;
import ru.tagall.emulatesystem.error.model.ApplicationErrorDto;

/**
 * Обрабочик ошибок.
 *
 * @author Iurii Babalin.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Обработка бизнес исключений.
     *
     * @param ex исключение.
     * @return {@link ApplicationErrorDto}
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ApplicationException.class)
    public ApplicationErrorDto handleApplicationException(ApplicationException ex) {
        log.debug("Exception happened {}", ex.getMessage());
        return ex.getError();
    }

}
