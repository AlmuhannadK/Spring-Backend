package com.luminousstore.luminousstore.controller.errors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;



@Order(Ordered.HIGHEST_PRECEDENCE) // hierarchy for handling exc from controller
@ControllerAdvice() // AOP :: provides service to controller component (i.e. all controllers)
public class RestExceptionHandler extends ResponseEntityExceptionHandler { // handleMethodArgumentNotValid is what needed


    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers,
                                                               HttpStatusCode status,
                                                               WebRequest request) {
        String error = "please enter valid inputs :: " + ex.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, error));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(HttpServletRequest request,
                                                               NoSuchElementException ex){

        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND);
        response.setMessage("no data found for this id in storage: " + request.getRequestURI());
        return buildResponseEntity(response);
    }

    // request body validation fail
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST);
        response.setMessage("not valid due to validation error: " + ex.getMessage());
        return buildResponseEntity(response);
    }

    public ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {

        return new ResponseEntity<Object>(errorResponse, errorResponse.getStatus());  // (header, http status)
    }

}