package ru.example.bookmarket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.example.bookmarket.BookException.BookNotFoundIdException;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    public ControllerAdvisor() {
    }

    @ExceptionHandler(BookNotFoundIdException.class)
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundIdException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Book not found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
