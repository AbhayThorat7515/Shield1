package com.AgileSof.Shield.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ShieldException.class)
    public ResponseEntity<?> ShieldException(ShieldException shieldException) {

        ResponseDto responseDTO = new ResponseDto();
        responseDTO.setCode(shieldException.getCode());
        responseDTO.setMessage(shieldException.getMessage());
        shieldException.printStackTrace();
        return ResponseEntity.internalServerError().body(responseDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(Exception exception) {

        ResponseDto responseDTO = new ResponseDto();
        responseDTO.setCode(500);
        responseDTO.setMessage(exception.getMessage());
        exception.printStackTrace();
        return ResponseEntity.internalServerError().body(responseDTO);
    }
}



