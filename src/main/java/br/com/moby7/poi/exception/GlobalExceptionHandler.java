package br.com.moby7.poi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> resourceDuplicateException(NotFoundException ex, WebRequest request) {
        DetalhesErro detalhesErro = new DetalhesErro(LocalDate.now(), ex.getMessage());
        return new ResponseEntity<>(detalhesErro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity<?> serviceUnavailableException(ServiceUnavailableException ex, WebRequest request) {
        DetalhesErro detalhesErro = new DetalhesErro(LocalDate.now(), ex.getMessage());
        return new ResponseEntity<>(detalhesErro, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(NotAcceptableException.class)
    public ResponseEntity<?> notAcceptableException(NotAcceptableException ex, WebRequest request) {
        DetalhesErro detalhesErro = new DetalhesErro(LocalDate.now(), ex.getMessage());
        return new ResponseEntity<>(detalhesErro, HttpStatus.NOT_ACCEPTABLE);
    }
}
