package com.bigsquare.user.service.exceptions;

import com.bigsquare.user.service.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotfoundException.class)
    public ResponseEntity<APIResponse> handleResourceNotFoundException(ResourceNotfoundException ex){

        String message = ex.getMessage();
        APIResponse response = APIResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<APIResponse>(response,HttpStatus.NOT_FOUND);
    }

}
