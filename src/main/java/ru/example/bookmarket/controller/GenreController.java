package ru.example.bookmarket.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.bookmarket.genre.Genre;

@RequestMapping(value = "/genre")
@RestController
@Tag(name = "Genre controller", description = "Get genres from table")
public interface GenreController {

    @Operation(summary = "Show all genres")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Show",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })
    @GetMapping("/page")
    Page<Genre> getGenres(@PageableDefault Pageable pageable);
}
