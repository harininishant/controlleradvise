package com.example.controlleradvice.controller;

import com.example.controlleradvice.BadNameException;
import com.example.controlleradvice.DuplicateIdentityException;
import com.example.controlleradvice.domain.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // alias for @ControllerAdvice along with @Response Body
//@ControllerAdvice(value = "BadNameException.class")
public class ErrorController {

    @ExceptionHandler(BadNameException.class)
    public ResponseEntity<?>handleBadName(Exception ex){
       return ResponseEntity.badRequest().body(ErrorResponse.builder().errorCode("401").message(ex.getMessage()).applicationId("1234").build());
    }


    @ExceptionHandler(DuplicateIdentityException.class)
    public ResponseEntity<?>handleDuplicate(Exception ex){
        return ResponseEntity.badRequest().body(ErrorResponse.builder()
                .errorCode("2032").message(ex.getMessage()).applicationId("1234").build());
    }
}
