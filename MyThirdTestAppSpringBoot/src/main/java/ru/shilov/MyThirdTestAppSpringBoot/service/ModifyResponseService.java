package ru.shilov.MyThirdTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.shilov.MyThirdTestAppSpringBoot.model.Response;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
