package ru.example.bookmarket.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDTO {
    private Long id;
    private String name;
    private String author;
    private Integer price;
}
