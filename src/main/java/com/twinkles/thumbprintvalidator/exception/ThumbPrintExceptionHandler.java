package com.twinkles.thumbprintvalidator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ThumbPrintExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ThumbPrintValidatorException.class)
    public ResponseEntity<?> handleThumbPrintException(ThumbPrintValidatorException thumbPrintValidatorException){
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(thumbPrintValidatorException.getMessage())
                .timeStamp(LocalDateTime.now())
                .responseCode("400")
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}
