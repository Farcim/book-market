package ru.example.bookmarket.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import ru.example.bookmarket.dto.BookDTO;
import ru.example.bookmarket.dto.BookDTOSave;


import java.util.List;

@RequestMapping(value = "/books")
@RestController
@Tag(name = "Book controller", description = "CRUD methods with book")
public interface BookController {
    @Operation(summary = "Save book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Save",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })
    @PostMapping
    BookDTO saveBook(@RequestBody BookDTOSave book);

    @Operation(summary = "Find by author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Show",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })
    @GetMapping
    List<BookDTO> findByAuthorName(@RequestParam(required = false) String authorName);

    @Operation(summary = "Find by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Show",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })
    @GetMapping("/{id}")
    BookDTO findById(@PathVariable Long id);

    @Operation(summary = "Update book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Update",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })

    @PutMapping
    void update(@RequestParam BookDTO book);

    @Operation(summary = "Delete by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Delete",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id);

    @Operation(summary = "Get all books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Get",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })
    @GetMapping("/page")
    Page<BookDTO> getByPage(@PageableDefault Pageable pageable);
}
