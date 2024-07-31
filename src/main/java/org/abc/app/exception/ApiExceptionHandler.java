package org.abc.app.exception;

import org.abc.app.dto.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.abc.app.dto.RestResponse.FAIL;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {

        return ResponseEntity.badRequest().body(new RestResponse(FAIL, e.getMessage()));
    }
}
