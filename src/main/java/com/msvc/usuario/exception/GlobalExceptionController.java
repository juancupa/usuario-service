package com.msvc.usuario.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionController {
    /*
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){

        String mensaje = resourceNotFoundException.getMessage();

        ApiResponse response = new ApiResponse().builder()
                .message(mensaje)
                .success(true)
                .status(HttpStatus.NOT_FOUND)
                .build();

        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }*/

@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity handlerResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){

        Map map = new HashMap();
        map.put("message", resourceNotFoundException.getMessage());
        map.put("success", false);
        map.put("status",HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
