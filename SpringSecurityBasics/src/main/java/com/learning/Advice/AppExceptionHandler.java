package com.learning.Advice;

import com.learning.Exception.EmailAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EmailAlreadyExists.class)
    public Map<String,String> handleEmailAlreadyExistsException(EmailAlreadyExists ex){
        Map<String, String> map = new HashMap<>();
        map.put("ErrorMessage",ex.getMessage());
        return map;
    }
}
