package ru.tagall.emulatesystem.error;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.tagall.emulatesystem.error.model.ApplicationErrorDto;

/**
 * Ошибки с комментариями.
 *
 * @author Iurii Babalin.
 */
@Getter
@RequiredArgsConstructor
public enum ErrorDescription {

    CUSTOMER_BED_BET(ErrorType.APP, "BET_001", "Пользователь не может перебить свою ставку."),
    CUSTOMER_SESSION_CLOSE(ErrorType.APP, "BET_002", "Пользователь не может сделать ставку в закрытую сессию."),

    UNAUTHORIZED_ACCESS(ErrorType.APP, "APP_001", "Неавторизованный доступ."),
    ACCESS_DENIED(ErrorType.APP, "APP_002", "Недостаточно прав для доступа к ресурсу."),
    HANDLER_NOT_FOUND(ErrorType.APP, "APP_003", "HANDLER_NOT_FOUND."),
    UNKNOWN_ERROR(ErrorType.APP, "APP_004", "Неизвестная ошибка сервера."),
    SERVICE_UNAVAILABLE(ErrorType.APP, "APP_005", "Сервис недоступен.");

    /**
     * Тип ошибки.
     */
    private final ErrorType type;

    /**
     * Код ошибки.
     */
    private final String code;

    /**
     * Сообщение ошибки.
     */
    private final String message;

    /**
     * Метод выбрасывает исключение приложения.
     *
     * @throws ApplicationException исключение приложения
     */
    public void throwException() throws ApplicationException {
        throw exception();
    }

    /**
     * Метод выбрасывает ислючение если объект == null.
     *
     * @param obj объект для проверки
     */
    public void throwIfNull(Object obj) {
        if (obj == null) {
            throw exception();
        }
    }

    /**
     * Метод выбрасывает ислючение если условие истинно.
     *
     * @param condition условие для проверки
     */
    public void throwIfTrue(Boolean condition) {
        if (condition) {
            throw exception();
        }
    }

    /**
     * Метод выбрасывает ислючение если условие ложно.
     *
     * @param condition условие для проверки
     */
    public void throwIfFalse(Boolean condition) {
        if (!condition) {
            throw exception();
        }
    }

    public ApplicationErrorDto createApplicationError() {
        return ApplicationErrorDto.of(this.type, this.code, this.message);
    }

    public ApplicationException exception() {
        return new ApplicationException(createApplicationError());
    }

}
