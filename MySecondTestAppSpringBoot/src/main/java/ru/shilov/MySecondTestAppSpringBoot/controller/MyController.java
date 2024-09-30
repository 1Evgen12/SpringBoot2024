package ru.shilov.MySecondTestAppSpringBoot.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.shilov.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.shilov.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.shilov.MySecondTestAppSpringBoot.model.*;
import ru.shilov.MySecondTestAppSpringBoot.service.ModifyRequestService;
import ru.shilov.MySecondTestAppSpringBoot.service.ModifyResponseService;
import ru.shilov.MySecondTestAppSpringBoot.service.ValidationService;
import ru.shilov.MySecondTestAppSpringBoot.util.DateTimeUtil;

import java.util.Date;

@Slf4j
@RestController
public class MyController {
    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifyOperationUidResponseService") ModifyResponseService modifyResponseService,
                        @Qualifier("ModifySystemNameRequestService")ModifyRequestService modifyRequestService){
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult){
        request.setSystemTime(DateTimeUtil.getCustomFormat2().format(new Date()));
        log.info("request: {}",request);
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMTY)
                .build();
        log.info("response: {}",response);

        Try TryC = new Try( validationService,modifyResponseService, modifyRequestService,
                bindingResult, request, response);
        return TryC.TryCatch(bindingResult, request, response);
    }
}
