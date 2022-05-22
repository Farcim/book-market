package ru.example.bookmarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.example.bookmarket.model.Book;
import ru.example.bookmarket.service.BookService;

@RequestMapping(value = "/book")
@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping
    public Book findBy(@RequestParam(required = false) String author, @RequestParam(required = false) String name) {
        return bookService.findBy(author, name);
    }

    @GetMapping(value = "/{id}")
    public Book findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public Book update(@RequestParam Book book, @PathVariable Long id) {
        return bookService.update(book, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}