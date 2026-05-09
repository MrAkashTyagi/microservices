package com.bigsquare.rating.exception;

import com.bigsquare.rating.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

@RestControllerAdvice
public class GlobalExcetionHandler {

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResorceNotFoundException exception){
        String message = exception.getMessage();
        ApiResponse apiResponse = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

}
