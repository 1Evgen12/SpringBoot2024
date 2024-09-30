package ru.shilov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.shilov.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.shilov.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.shilov.MySecondTestAppSpringBoot.model.Request;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
    void uid123(Request request) throws UnsupportedCodeException;
}
