package ru.shilov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.shilov.MySecondTestAppSpringBoot.model.Response;
@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
