package ru.example.bookmarket.exception;

import javax.persistence.EntityNotFoundException;

public class GenreNotFoundException extends EntityNotFoundException {
    public GenreNotFoundException(int id) {
        super(String.format("Genre with id '%d' is not exist", id));
    }

    public GenreNotFoundException(String name) {
        super(String.format("Genre with name '%s' is not exist", name));
    }

}
