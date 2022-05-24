package ru.example.bookmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.bookmarket.BookException.BookNotFoundException;
import ru.example.bookmarket.repository.BookRepository;
import ru.example.bookmarket.model.Book;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book findBy(String author, String name) {
        if (author != null) {
            return bookRepository.findByAuthor(author);
        } else if (name != null) {
            return bookRepository.findByName(name);
        }
        throw new EntityNotFoundException("Book is not found");
    }

    public Book findById(Long id) {
        if (bookRepository.existsById(id)) {
            return bookRepository.findById(id).get();
        }
        throw new BookNotFoundException(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
        throw new BookNotFoundException(id);
    }

    public Book update(Book book, Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.save(book);
        }
        throw new BookNotFoundException(id);
    }

}
