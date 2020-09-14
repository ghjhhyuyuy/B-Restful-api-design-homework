package com.thoughtworks.capability.gtb.restfulapidesign.handler;

import com.thoughtworks.capability.gtb.restfulapidesign.exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by wzw on 2020/9/14.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({MyException.class})
    public ResponseEntity<Exception> handle(Exception exception) {
        HttpStatus state = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(state).body(exception);
    }
}
