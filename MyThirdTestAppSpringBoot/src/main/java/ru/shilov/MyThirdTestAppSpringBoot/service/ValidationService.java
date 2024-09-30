package ru.shilov.MyThirdTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.shilov.MyThirdTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.shilov.MyThirdTestAppSpringBoot.exception.ValidationFailedException;
import ru.shilov.MyThirdTestAppSpringBoot.model.Request;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
    void uid123(Request request) throws UnsupportedCodeException;
}
