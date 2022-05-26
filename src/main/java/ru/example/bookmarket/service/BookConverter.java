package ru.example.bookmarket.service;

import org.springframework.stereotype.Service;
import ru.example.bookmarket.dto.BookDTO;
import ru.example.bookmarket.model.Book;

@Service
public class BookConverter {
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
}
