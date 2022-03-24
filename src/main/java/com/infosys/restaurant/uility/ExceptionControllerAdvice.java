package com.infosys.restaurant.uility;

import com.infosys.restaurant.exception.RestaurantServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

import static java.util.stream.Collectors.joining;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(RestaurantServiceException.class)
    public ResponseEntity<ErrorInfo> restaurantExceptionHandler(RestaurantServiceException exception){
        ErrorInfo errorInfo = new ErrorInfo(exception.getMessage(), BAD_REQUEST.value(), LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, BAD_REQUEST);
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class, ConstraintViolationException.class })
    public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setErrorCode(BAD_REQUEST.value());
        String errorMsg = "";
        if (exception instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception1 = (MethodArgumentNotValidException) exception;
            errorMsg = exception1.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage())
                    .collect(joining(", "));
        } else {
            ConstraintViolationException exception1 = (ConstraintViolationException) exception;
            errorMsg = exception1.getConstraintViolations().stream().map(x -> x.getMessage())
                    .collect(joining(", "));
        }
        errorInfo.setMessage(errorMsg);
        errorInfo.setTime(LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, BAD_REQUEST);
    }
}
