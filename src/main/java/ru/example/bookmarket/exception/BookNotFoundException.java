package ru.example.bookmarket.exception;

import javax.persistence.EntityNotFoundException;

public class BookNotFoundException extends EntityNotFoundException {
    public BookNotFoundException(Long id) {
        super(String.format("Book with id '%d' is not exist", id));
    }

    public BookNotFoundException(String name) {
        super(String.format("Book with id '%s' is not exist", name));
    }
}
