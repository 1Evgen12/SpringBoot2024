package ru.shilov.MySecondTestAppSpringBoot.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    //Уникальный идентификатор сообщения
    @NotBlank(message = "UID не может быть пустым")
    private String uid;
    //Уникальный идентификатор операции
    @NotBlank(message = "operationUid не может быть пустым")
    private String operationUid;
    //Имя системы отправителя
    private Systems systemName;
    //Время создания сообщения
    @NotBlank(message = "systemTime не может быть пустым")
    private String systemTime;
    //Наименование ресурса
    private String source;
    //Должность сотрудника
    private Positions position;
    //Является ли сотрудник управленцем
    private boolean isManager;
    //Зар. плата сотрудника
    private double salary;
    //Бонус сотрудника
    private double bonus;
    //Количество рабочих дней
    private int workDays;
    //Уникальный идентификатор коммуникации
    @Min(value = 1, message = "Минимальное значение для communicationId - 1") @Max(value=100000, message = "Максимальное значение для communicationId - 100000")
    private int communicationId;
    //Уникальный идентификатор шаблона
    private int templateId;
    //Код продукта
    private int productCode;
    //Смс код
    private int smsCode;

    @Override
    public String toString(){
        return "{" +
                "uid='" + uid + '\''+
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\''+
                ", source='" + source + '\'' +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode+
                ", smsCode="+ smsCode+
                '}';
    }
}
