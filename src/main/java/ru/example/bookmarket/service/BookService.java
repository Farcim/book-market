package ru.example.bookmarket.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import ru.example.bookmarket.BookException.BookNotFoundIdException;
import ru.example.bookmarket.repository.BookRepository;
import ru.example.bookmarket.model.Book;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

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
        if (bookRepository.existsById(id)) bookRepository.findById(id);
        throw new BookNotFoundIdException(id);
    }
//    public Book findByBook(Book book){
//        Map<Author,Name> map = new HashMap<>();
//        if(bookRepository.exists(map)){
//            return  book;
//        }
//        throw new EntityNotFoundException("Book is not exist");
//    }

    public Book saveBook(Book book) {
        if(bookRepository.findByBook(book)!=null) {
            return bookRepository.save(book);
        }
        throw new EntityNotFoundException("Book is not exist");
    }

    public void deleteById(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
        throw new BookNotFoundIdException(id);
    }

    public void update(Book book, Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.save(book);
        } else {
            throw new BookNotFoundIdException(id);
        }
    }

}
