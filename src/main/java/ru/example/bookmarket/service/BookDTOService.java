package ru.example.bookmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.bookmarket.dto.BookDTO;
import ru.example.bookmarket.model.Book;
import ru.example.bookmarket.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookDTOService {

    private BookRepository bookRepository;

    private BookDTO convertEntityToDTO(Book book){
        return BookDTO.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .name(book.getName())
                .price(book.getPrice())
                .build();
    }
}
