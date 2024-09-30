package ru.shilov.MySecondTestAppSpringBoot.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    //Уникальный идентификатор сообщения
    private String uid;
    //Уникальный идентификатор операции
    private String operationUid;
    //Время создания сообщения
    private String systemTime;
    //Код ошибки
    private Codes code;
    //Годовая премия
    private Double annualBonus;
    //Наименование ошибки
    private ErrorCodes errorCode;
    //Сообщение об ошибке
    private ErrorMessages errorMessage;
}
