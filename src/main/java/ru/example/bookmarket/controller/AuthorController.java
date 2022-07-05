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
import ru.example.bookmarket.dto.AuthorDTO;

@RequestMapping(value = "/author")
@RestController
@Tag(name = "Author controller", description = "CRUD methods with author")
public interface AuthorController {
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
    AuthorDTO save(@RequestBody AuthorDTO authorDTO);

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
    AuthorDTO findById(@PathVariable Long id);

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
    void deleteById(@PathVariable Long id);

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
    void update(@RequestParam AuthorDTO authorDTO);

    @Operation(summary = "Get authors")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Get",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not available",
                    content = @Content)
    })
    @GetMapping("/pageable")
    Page<AuthorDTO> getByPage(@PageableDefault(size = 5, page = 0) Pageable pageable);
}
