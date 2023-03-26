package com.it_academy.client.web.errorhandler;

import com.it_academy.data.dto.web.ErrorDto;
import com.it_academy.data.dto.web.ValidationResultDto;
import com.it_academy.exception.controller.ClientException;
import com.it_academy.exception.controller.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RestControllerAdvice("com.it_academy.client.web.rest")
public class RestErrorHandler {

    private static final String SERVER_ERROR = "Server Error";
    private static final String CLIENT_ERROR = "Client Error";
    private static final String SERVER_ERROR_DEFAULT_MESSAGE = "Something went wrong...";

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto error(ClientException e) {
        return new ErrorDto(CLIENT_ERROR, e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto error(Exception e) {
        return new ErrorDto(SERVER_ERROR, SERVER_ERROR_DEFAULT_MESSAGE);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ValidationResultDto validationError(ValidationException e) {
        Map<String, List<String>> errors = mapError(e.getErrors());
        return new ValidationResultDto(errors);
    }

    private Map<String, List<String>> mapError(Errors rawErrors) {
        return rawErrors.getFieldErrors()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                FieldError::getField,
                                Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())
                        )
                );
    }
}
