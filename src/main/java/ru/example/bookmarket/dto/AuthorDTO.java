package ru.example.bookmarket.dto;

import lombok.Builder;
import lombok.Data;
import ru.example.bookmarket.genre.Genre;

import java.util.Set;
@Data
@Builder
public class AuthorDTO {
    private Long id;
    private String name;
    private Set<Genre> genres;

}
