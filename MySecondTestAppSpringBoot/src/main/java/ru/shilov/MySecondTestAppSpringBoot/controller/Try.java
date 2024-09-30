package ru.shilov.MySecondTestAppSpringBoot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import ru.shilov.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.shilov.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.shilov.MySecondTestAppSpringBoot.model.*;
import ru.shilov.MySecondTestAppSpringBoot.service.ModifyRequestService;
import ru.shilov.MySecondTestAppSpringBoot.service.ModifyResponseService;
import ru.shilov.MySecondTestAppSpringBoot.service.ValidationService;
@Slf4j
public class Try {

    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifyRequestService;
    private final BindingResult bindingResult;
    private final Response response;
    private final Request request;

    Try(ValidationService validationService, ModifyResponseService modifyResponseService,ModifyRequestService modifyRequestService,
        BindingResult bindingResult, Request request, Response response){
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
        this.bindingResult = bindingResult;
        this.response = response;
        this.request = request;
    }

    public ResponseEntity<Response> TryCatch(BindingResult bindingResult, Request request, Response response){
        try{
            validationService.isValid(bindingResult);
            validationService.uid123(request);
        }catch (ValidationFailedException e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.error("response: {}",bindingResult.getFieldErrors());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }catch (UnsupportedCodeException ex){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            log.error("response: {}",bindingResult.getFieldError());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.error("response: {}",bindingResult.getFieldErrors());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        modifyResponseService.modify(response);
        modifyRequestService.modify(request);
        log.info("response: {}",response);
        return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);
    }
}
