package com.example.subscribing.domain.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProgramServiceErrorHandler {
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<Error> handleCommonException(CommonException commonException){
        Error error = new Error(commonException.getCode(), commonException.getMessage());
        return new ResponseEntity<>(error, commonException.getHttpStatus());
    }
}
