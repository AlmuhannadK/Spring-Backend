package com.luminousstore.luminousstore.controller.errors;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
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

        String error = "Unable to submit post. Please enter valid data: " + ex.getMessage();

        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, error));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(HttpServletRequest request,  NoSuchElementException ex){
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND);
        response.setMessage("TESTTESTESTESTEST : " + request.getRequestURI());
        return buildResponseEntity(response);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {
                // (header, httpstatus)
        return new ResponseEntity<Object>(errorResponse, errorResponse.getStatus());
    }


}


//// Exceptions to handle

//NoSuchElementException (data not available)

//MethodArgumentNotValidException (invalid argument passed)

//HttpMessageNotReadableException (missing field)
