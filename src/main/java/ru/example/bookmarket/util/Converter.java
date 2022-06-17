package ru.example.bookmarket.util;

import ru.example.bookmarket.dto.AuthorDTO;
import ru.example.bookmarket.dto.BookDTO;
import ru.example.bookmarket.dto.GenreDTO;
import ru.example.bookmarket.model.Author;
import ru.example.bookmarket.model.Book;
import ru.example.bookmarket.model.Genre;

import java.util.stream.Collectors;

public class Converter {
    public static BookDTO bookToDTO(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .authors(book.getAuthor()
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
                .author(bookDTO.getAuthors()
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
                        .map(Converter::genreToDTO)
                        .collect(Collectors.toSet()))
                .name(author.getName())
                .build();
    }

    public static Author dtoToAuthor(AuthorDTO authorDTO) {
        return Author.builder()
                .id(authorDTO.getId())
                .genres(authorDTO.getGenres()
                        .stream()
                        .map(Converter::dtoToGenre)
                        .collect(Collectors.toSet()))
                .name(authorDTO.getName())
                .build();
    }

    public static GenreDTO genreToDTO(Genre genre) {
        return GenreDTO.builder()
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }

    public static Genre dtoToGenre(GenreDTO genreDTO) {
        return Genre.builder()
                .id(genreDTO.getId())
                .name(genreDTO.getName())
                .build();
    }

}
