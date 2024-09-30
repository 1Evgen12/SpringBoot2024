package ru.shilov.MyThirdTestAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorMessages {
    EMTY(""),
    VALIDATION("Ошибка валидации"),
    UNSUPPORTED("Не поддерживаемая ошибка"),
    UNKNOWN("Произошла непредвиденная ошибка");

    private final String description;

    ErrorMessages(String description){
        this.description = description;
    }
    @JsonValue
    public String getName(){
        return description;
    }
}
