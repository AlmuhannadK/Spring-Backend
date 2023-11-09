package com.luminousstore.luminousstore.controller.errors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE) // hierarchy for handling ex from controller
@ControllerAdvice() // AOP :: provides service to controller component (i.e. all controllers)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


}
