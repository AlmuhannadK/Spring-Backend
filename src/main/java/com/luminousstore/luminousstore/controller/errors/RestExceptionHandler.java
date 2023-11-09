package com.luminousstore.luminousstore.controller.errors;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@Order(Ordered.HIGHEST_PRECEDENCE) // hierarchy for handling ex from controller
@ControllerAdvice() // AOP :: provides service to controller component (i.e. all controllers)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    //handles specific exc thrown by controller
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentException(HttpServletRequest request,  MethodArgumentNotValidException ex){

        return null;
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(HttpServletRequest request,  NoSuchElementException ex){

        return null;
    }



}


//NoSuchElementException (data not available)

//MethodArgumentNotValidException (invalid argument passed)

//HttpMessageNotReadableException (missing field)
