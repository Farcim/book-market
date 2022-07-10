package ru.example.bookmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.example.bookmarket.dto.BookDTO;
import ru.example.bookmarket.dto.BookDTOSave;
import ru.example.bookmarket.exception.AuthorNotFoundException;
import ru.example.bookmarket.exception.BookNotFoundException;
import ru.example.bookmarket.exception.InvalidRequestException;
import ru.example.bookmarket.model.Author;
import ru.example.bookmarket.model.Book;
import ru.example.bookmarket.model.Genre;
import ru.example.bookmarket.repository.BookRepository;
import ru.example.bookmarket.util.Converter;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final GenreService genreService;

    public List<BookDTO> findByAuthorName(String authorName) {
        if (authorName != null) {
            try {
                return bookRepository.findByAuthorName(authorName).stream()
                        .map(Converter::bookToDTO)
                        .collect(Collectors.toList());
            } catch (EntityNotFoundException e) {
                throw new AuthorNotFoundException(authorName);
            }
        } else {
            throw new InvalidRequestException("You entered empty name");
        }
    }

    public BookDTO findById(Long id) {
        return Converter.bookToDTO(bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id)));
    }

    public void deleteById(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new BookNotFoundException(id);
        }
    }

    public void update(BookDTO book) {
        if (bookRepository.existsById(book.getId())) {
            bookRepository.save(Converter.dtoToBook(book));
        } else {
            throw new BookNotFoundException(book.getId());
        }
    }

    public BookDTO save(BookDTOSave dto) {
        List<Genre> genres = genreService.findAllByIds(dto.getGenreIds());
        List<Author> authors = authorService.findAllByIds(dto.getAuthorIds());
        Book book = Book.builder()
                .id(dto.getId())
                .name(dto.getName())
                .genres(new HashSet<>(genres))
                .authors(new HashSet<>(authors))
                .price(dto.getPrice())
                .build();
        return Converter.bookToDTO(bookRepository.save(book));
    }

    public Page<BookDTO> getByPage(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(Converter::bookToDTO);
    }

}
