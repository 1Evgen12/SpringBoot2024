package ru.shilov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.shilov.MySecondTestAppSpringBoot.model.Request;

@Service
public interface ModifyRequestService {
    void modify(Request request);
}
