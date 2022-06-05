package ru.example.bookmarket.util;

import ru.example.bookmarket.dto.AuthorDTO;
import ru.example.bookmarket.dto.BookDTO;
import ru.example.bookmarket.model.Author;
import ru.example.bookmarket.model.Book;

public class Converter {
    public static BookDTO convertEntityToDTO(Book book){
        return BookDTO.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .name(book.getName())
                .price(book.getPrice())
                .build();
    }
    public static Book convertDTOToEntity(BookDTO bookDTO){
        return Book.builder()
                .id(bookDTO.getId())
                .author(bookDTO.getAuthor())
                .name(bookDTO.getName())
                .price(bookDTO.getPrice())
                .build();
    }
    public static AuthorDTO convertEntityToDTO(Author author){
        return AuthorDTO.builder()
                .id(author.getId())
                .genres(author.getGenres())
                .name(author.getName())
                .build();
    }
    public static Author convertDTOToEntity(AuthorDTO authorDTO){
        return Author.builder()
                .id(authorDTO.getId())
                .genres(authorDTO.getGenres())
                .name(authorDTO.getName())
                .build();
    }
}
