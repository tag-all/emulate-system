package ru.tagall.emulatesystem.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.tagall.emulatesystem.error.model.ApplicationErrorDto;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

/**
 * Обработчик ошибки.
 *
 * @author Iuri Babalin.
 */
@Component
@RequiredArgsConstructor
public class HttpResponseUtils extends ResponseEntityExceptionHandler {

    private static ObjectMapper staticObjectMapper;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public static void writeError(HttpServletResponse response, ApplicationErrorDto error, int status) {
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(status);
        staticObjectMapper.writeValue(response.getOutputStream(), error);
    }

    @PostConstruct
    public void postConstruct() {
        staticObjectMapper = this.objectMapper;
    }

}

