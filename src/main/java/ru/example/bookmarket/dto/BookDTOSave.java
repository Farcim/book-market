package ru.example.bookmarket.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class BookDTOSave {
    private Long id;
    private String name;
    private Set<Long> authorIds;
    private Set<Integer> genreIds;
    private Integer price;
}
