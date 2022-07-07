package ru.example.bookmarket.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import ru.example.bookmarket.genre.Genre;

import java.util.Set;


@Data
@Builder
@Schema(description = "book entity", title = "book", name = "Book")
public class BookDTO  {
    @Schema(type = "int64", example = "null")
    private Long id;
    @Schema(type = "string", example = "Кот и пес")
    private String name;
    private Set<AuthorDTO> authors;
    private Set<Genre> genres;
    @Schema(type = "int32", example = "456.3")
    private Integer price;
}
