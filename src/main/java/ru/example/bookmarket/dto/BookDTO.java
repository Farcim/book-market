package ru.example.bookmarket.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;


@Data
@Builder
public class BookDTO  {
    private Long id;
    private String name;
    private Set<AuthorDTO> author;
    private Integer price;
}
