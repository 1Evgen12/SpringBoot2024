package ru.shilov.MySecondTestAppSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonValue;
import ru.shilov.MySecondTestAppSpringBoot.exception.ValidationFailedException;

public enum ErrorCodes {
    EMPTY(""),
    VALIDATION_EXCEPTION("ValidationException"),
    UNKNOWN_EXCEPTION("UnknownException"),
    UNSUPPORTED_EXCEPTION("UnsupportedException");
    private final String name;

    ErrorCodes(String name){
        this.name = name;
    }

    @JsonValue
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return name;
    }
}
