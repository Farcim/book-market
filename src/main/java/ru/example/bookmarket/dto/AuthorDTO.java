package ru.example.bookmarket.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import ru.example.bookmarket.genre.Genre;

import java.util.Set;
@Data
@Builder
@Schema
public class AuthorDTO {
    @Schema(type = "string", example = " ")
    private Long id;
    @Schema(type = "string", example = " ")
    private String name;
    private Set<Genre> genres;

}
