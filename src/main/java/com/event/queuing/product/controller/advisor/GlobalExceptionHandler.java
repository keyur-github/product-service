package com.event.queuing.product.controller.advisor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException runtimeException) {
        log.error("Something went wrong");
        return new ResponseEntity<>("Something went wrong", HttpStatus.SERVICE_UNAVAILABLE);
    }


}
