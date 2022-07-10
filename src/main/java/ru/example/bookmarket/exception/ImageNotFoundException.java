package ru.example.bookmarket.exception;

import javax.persistence.EntityNotFoundException;

public class ImageNotFoundException extends EntityNotFoundException {
    public ImageNotFoundException(Long id) {
        super(String.format("Image with id '%d' is not exist", id));
    }
}
