package com.infosys.restaurant.uility;

import com.infosys.restaurant.exception.RestaurantServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(RestaurantServiceException.class)
    public ResponseEntity<ErrorInfo> restaurantExceptionHandler(RestaurantServiceException exception){
        ErrorInfo errorInfo = new ErrorInfo(exception.getMessage(), INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, INTERNAL_SERVER_ERROR);
    }
}
