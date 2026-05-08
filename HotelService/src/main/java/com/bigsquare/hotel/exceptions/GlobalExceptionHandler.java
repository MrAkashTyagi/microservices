package com.bigsquare.hotel.exceptions;

import com.bigsquare.hotel.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFondException.class)
    public ResponseEntity<APIResponse> handleResourceNotFoundException(ResourceNotFondException exception) {
        String message = exception.getMessage();
        APIResponse response = APIResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<APIResponse>(response, HttpStatus.NOT_FOUND);
    }

}
