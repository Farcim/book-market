package ru.example.bookmarket.dto;

import lombok.Builder;
import lombok.Data;
import ru.example.bookmarket.model.Author;

@Data
@Builder
public class BookDTO  {
    private Long id;
    private String name;
    private Author author;
    private Integer price;
}
