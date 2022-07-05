package ru.example.bookmarket.dto;

import lombok.Builder;
import lombok.Data;
import ru.example.bookmarket.genre.Genre;

import java.util.Set;


@Data
@Builder
public class BookDTO  {
    private Long id;
    private String name;
    private Set<AuthorDTO> authors;
    private Set<Genre> genres;
    private Integer price;
}
