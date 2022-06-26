package ru.example.bookmarket.util;

import ru.example.bookmarket.dto.AuthorDTO;
import ru.example.bookmarket.dto.BookDTO;
import ru.example.bookmarket.exception.GenreNotFoundException;
import ru.example.bookmarket.model.Author;
import ru.example.bookmarket.model.Book;
import ru.example.bookmarket.model.Genre;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Converter {
    public static BookDTO bookToDTO(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .authors(book.getAuthors()
                        .stream()
                        .map(Converter::authorToDTO)
                        .collect(Collectors.toSet()))
                .name(book.getName())
                .price(book.getPrice())
                .build();
    }

    public static Book dtoToBook(BookDTO bookDTO) {
        return Book.builder()
                .id(bookDTO.getId())
                .authors(bookDTO.getAuthors()
                        .stream()
                        .map(Converter::dtoToAuthor)
                        .collect(Collectors.toSet()))
                .name(bookDTO.getName())
                .price(bookDTO.getPrice())
                .build();
    }

    public static AuthorDTO authorToDTO(Author author) {
        return AuthorDTO.builder()
                .id(author.getId())
                .genres(author.getGenres()
                        .stream()
                        .map(Converter::convert)
                        .collect(Collectors.toSet()))
                .name(author.getName())
                .build();
    }

    public static Author dtoToAuthor(AuthorDTO authorDTO) {
        return Author.builder()
                .id(authorDTO.getId())
                .genres(authorDTO.getGenres()
                        .stream()
                        .map(Converter::convert)
                        .collect(Collectors.toSet()))
                .name(authorDTO.getName())
                .build();
    }

    public static ru.example.bookmarket.genries.Genre convert(Genre genre) {
        return Stream.of(ru.example.bookmarket.genries.Genre.values())
                .filter(genreModel -> Objects.equals(genre.getName(), genreModel.name()))
                .findFirst()
                .orElseThrow(() -> new GenreNotFoundException(genre.getName()));
    }

    public static Genre convert(ru.example.bookmarket.genries.Genre genreEnum) {
        return Genre.builder()
                .name(genreEnum.name())
                .id(genreEnum.getId())
                .build();
    }

}
