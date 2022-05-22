package ru.example.bookmarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.example.bookmarket.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Book findById(@PathVariable Long id){
        return bookService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public void update(@RequestParam Book book, @PathVariable Long id) {
        bookService.update(book, id);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

}


