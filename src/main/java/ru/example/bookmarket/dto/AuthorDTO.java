package ru.example.bookmarket.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import ru.example.bookmarket.genre.Genre;

import java.util.Set;
@Data
@Builder
@Schema(description = "author entity", title = "author")
public class AuthorDTO {
    @Schema(type = "int64", example = "null")
    private Long id;
    @Schema(type = "string", example = "Дмитрий Петрович")
    private String name;
    private Set<Genre> genres;

}
