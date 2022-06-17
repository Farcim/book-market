package ru.example.bookmarket.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.example.bookmarket.dto.GenreDTO;
import ru.example.bookmarket.service.GenreService;

@RequestMapping(value = "/genre")
@RestController
@RequiredArgsConstructor
@Tag(name = "Genre controller", description = "CRUD methods with genre")
public class GenreController {
    private final GenreService genreService;

    @Operation(summary = "Save genre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Save",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })
    @PostMapping
    public GenreDTO save(@RequestBody GenreDTO genreDTO) {
        return genreService.save(genreDTO);
    }

    @Operation(summary = "Find genre by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Find",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public GenreDTO findById(@PathVariable Long id) {
        return genreService.findById(id);
    }

    @Operation(summary = "Update genre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Update",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })
    public void update(@RequestParam GenreDTO genreDTO) {
        genreService.update(genreDTO);
    }

    @Operation(summary = "Delete genre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Delete",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        genreService.deleteById(id);
    }
}
