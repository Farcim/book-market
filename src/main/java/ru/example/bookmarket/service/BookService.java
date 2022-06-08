package ru.example.bookmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.bookmarket.dto.BookDTO;
import ru.example.bookmarket.exception.BookNotFoundException;
import ru.example.bookmarket.model.Book;
import ru.example.bookmarket.repository.BookRepository;
import ru.example.bookmarket.util.Converter;

import javax.persistence.EntityNotFoundException;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public BookDTO findBy(String author) {
        if (author != null) {
            return Converter.bookToDTO(bookRepository.findByAuthor(author));
        }
        throw new EntityNotFoundException("Book is not found");
    }

    public BookDTO findById(Long id) {
        return Converter.bookToDTO(bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id)));
    }

    public void deleteById(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
        throw new BookNotFoundException(id);
    }

    public void update(BookDTO book) {
        if (bookRepository.existsById(book.getId())) {
            bookRepository.save(Converter.dtoToBook(book));
        } else {
            throw new BookNotFoundException(book.getId());
        }
    }

    public BookDTO save(BookDTO bookDTO) {
        Book book = Converter.dtoToBook(bookDTO);
        return Converter.bookToDTO(bookRepository.save(book));
    }
}
