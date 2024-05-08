package com.example.testspring.exceptions;

import com.example.testspring.models.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<ResponseError> handleConflict(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<ResponseError>(new ResponseError("Illegal Argument", 12345), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { SQLException.class })
    protected ResponseEntity<ResponseError> sqlHandler(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<ResponseError>(new ResponseError("Db down", 12345), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<ResponseError> globalHandler(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<ResponseError>(new ResponseError("Internal server error", 12345), HttpStatus.BAD_REQUEST);
    }
}
