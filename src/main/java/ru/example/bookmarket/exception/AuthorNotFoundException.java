package ru.example.bookmarket.exception;

import javax.persistence.EntityNotFoundException;

public class AuthorNotFoundException extends EntityNotFoundException {
    public AuthorNotFoundException(Long id) {
        super(String.format("Author with id '%d' is not exist", id));
    }

    public AuthorNotFoundException(String name) {
        super(String.format("Author with id '%s' is not exist", name));
    }
}