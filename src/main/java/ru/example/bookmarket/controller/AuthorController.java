package ru.example.bookmarket.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.example.bookmarket.dto.AuthorDTO;
import ru.example.bookmarket.service.AuthorService;

@RequestMapping(value = "/author")
@RestController
@RequiredArgsConstructor
@Tag(name = "Author controller", description = "CRUD methods with author")
public class AuthorController {
    private final AuthorService authorService;
    @Operation(summary = "Save author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Save",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })
    @PostMapping
    public AuthorDTO save(@RequestBody AuthorDTO authorDTO){
        return authorService.save(authorDTO);
    }
    @Operation(summary = "Find author by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Find",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public AuthorDTO findById(@PathVariable Long id){
        return authorService.findById(id);
    }
    @Operation(summary = "Delete author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Delete",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        authorService.deleteById(id);
    }
    @Operation(summary = "Update author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Update",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })
    @PutMapping
    public void update(@RequestParam AuthorDTO authorDTO){
        authorService.update(authorDTO);
    }

}
