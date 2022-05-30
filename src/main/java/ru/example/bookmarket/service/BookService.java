package ru.example.bookmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.bookmarket.BookException.BookNotFoundIdException;
import ru.example.bookmarket.dto.BookDTO;
import ru.example.bookmarket.model.Book;
import ru.example.bookmarket.repository.BookRepository;

import javax.persistence.EntityNotFoundException;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public BookDTO findBy(String author) {
        if (author != null) {
            return BookConverter.convertEntityToDTO(bookRepository.findByAuthor(author));
        }
        throw new EntityNotFoundException("Book is not found");
    }

    public BookDTO findById(Long id) {
        return BookConverter.convertEntityToDTO(bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundIdException(id)));
    }

    public void deleteById(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
        throw new BookNotFoundIdException(id);
    }

    public void update(BookDTO book) {
        if (bookRepository.existsById(book.getId())) {
            bookRepository.save(BookConverter.convertDTOToEntity(book));
        } else {
            throw new BookNotFoundIdException(book.getId());
        }
    }

    public BookDTO save(BookDTO bookDTO) {
        Book book = BookConverter.convertDTOToEntity(bookDTO);
        return BookConverter.convertEntityToDTO(bookRepository.save(book));
    }
}
