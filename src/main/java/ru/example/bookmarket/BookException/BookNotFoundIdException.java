package ru.example.bookmarket.BookException;

import javax.persistence.EntityNotFoundException;

public class BookNotFoundIdException extends EntityNotFoundException {
    public BookNotFoundIdException(Long id){
        super(String.format("Book with id %d is not exist",id));
    }

}
