package ru.example.bookmarket.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.nio.charset.Charset;

public class InvalidRequestException extends RuntimeException {


    public InvalidRequestException(String message) {
        super(message);
    }


}
