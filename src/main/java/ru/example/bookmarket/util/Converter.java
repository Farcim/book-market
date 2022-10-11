package ru.example.bookmarket.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import ru.example.bookmarket.dto.AuthorDTO;
import ru.example.bookmarket.dto.BookDTO;
import ru.example.bookmarket.exception.GenreNotFoundException;
import ru.example.bookmarket.exception.ImageSaveException;
import ru.example.bookmarket.model.Author;
import ru.example.bookmarket.model.Book;
import ru.example.bookmarket.model.Genre;
import ru.example.bookmarket.model.Image;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Converter {
    public static BookDTO bookToDTO(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .authors(book.getAuthors()
                        .stream()
                        .map(Converter::authorToDTO)
                        .collect(Collectors.toSet()))
                .genres(book.getGenres()
                        .stream()
                        .map(Converter::entityToEnum)
                        .collect(Collectors.toSet()))
                .name(book.getName())
                .price(book.getPrice())
                .creationDate(book.getCreationDate())
                .build();
    }

    public static Book dtoToBook(BookDTO bookDTO) {
        return Book.builder()
                .id(bookDTO.getId())
                .authors(bookDTO.getAuthors()
                        .stream()
                        .map(Converter::dtoToAuthor)
                        .collect(Collectors.toSet()))
                .genres(bookDTO.getGenres()
                        .stream()
                        .map(Converter::enumToEntity)
                        .collect(Collectors.toSet()))
                .name(bookDTO.getName())
                .price(bookDTO.getPrice())
                .creationDate(bookDTO.getCreationDate())
                .build();
    }

    public static AuthorDTO authorToDTO(Author author) {
        return AuthorDTO.builder()
                .id(author.getId())
                .genres(author.getGenres()
                        .stream()
                        .map(Converter::entityToEnum)
                        .collect(Collectors.toSet()))
                .name(author.getName())
                .build();
    }

    public static Author dtoToAuthor(AuthorDTO authorDTO) {
        return Author.builder()
                .id(authorDTO.getId())
                .genres(authorDTO.getGenres()
                        .stream()
                        .map(Converter::enumToEntity)
                        .collect(Collectors.toSet()))
                .name(authorDTO.getName())
                .build();
    }

    public static ru.example.bookmarket.genre.Genre entityToEnum(Genre genre) {
        return Stream.of(ru.example.bookmarket.genre.Genre.values())
                .filter(genreModel -> Objects.equals(genre.getName(), genreModel.name()))
                .findFirst()
                .orElseThrow(() -> new GenreNotFoundException(genre.getName()));
    }

    public static Genre enumToEntity(ru.example.bookmarket.genre.Genre genreEnum) {
        return Genre.builder()
                .name(genreEnum.name())
                .id(genreEnum.getId())
                .build();
    }

    public static Image toImageEntity(MultipartFile file) {
        try {
            return Image.builder()
                    .name(file.getName())
                    .type(file.getContentType())
                    .size(file.getSize())
                    .bytes(file.getBytes())
                    .build();
        } catch (IOException e) {
            throw new ImageSaveException(e);
        }
    }
}
