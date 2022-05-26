package ru.example.bookmarket.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.example.bookmarket.dto.BookDTO;
import ru.example.bookmarket.service.BookService;

@RequestMapping(value = "/book")
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public BookDTO saveBook(@RequestBody BookDTO book) {
        return bookService.save(book);
    }

    @GetMapping
    public BookDTO findBy(@RequestParam(required = false) String author, @RequestParam(required = false) String name) {
        return bookService.findBy(author, name);
    }

    @Operation(summary = "Find by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Show",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })
    @GetMapping
    public BookDTO findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PutMapping
    public void update(@RequestParam BookDTO book) {
        bookService.update(book);
    }


    @DeleteMapping
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

}


