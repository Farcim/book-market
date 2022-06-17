package ru.example.bookmarket.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenreDTO {
    private Long id;
    private String name;
}
