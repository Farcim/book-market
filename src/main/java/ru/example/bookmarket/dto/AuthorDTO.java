package ru.example.bookmarket.dto;

import lombok.Builder;
import lombok.Data;
import ru.example.bookmarket.genries.Genre;
import java.util.Set;

@Builder
@Data
public class AuthorDTO {
    private Long id;
    private String name;
    private Set<Genre> genres;

}
