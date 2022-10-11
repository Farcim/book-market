package ru.example.bookmarket.exception;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
public class ImageSaveException extends RuntimeException {
    public ImageSaveException(IOException e) {
        log.info("Something went wrong, please try again later.",e);
    }

}
