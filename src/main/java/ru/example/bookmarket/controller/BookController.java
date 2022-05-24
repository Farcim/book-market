package ru.example.bookmarket.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.example.bookmarket.dto.BookDTO;
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
    @Operation(summary = "Show all books from db")
    @ApiResponses(value = {
            @ApiResponse(responseCode="200",
                    description = "Show",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content =@Content)
    })
    @GetMapping(value = "/{id}")
    public BookDTO findById(@PathVariable Long id){
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


