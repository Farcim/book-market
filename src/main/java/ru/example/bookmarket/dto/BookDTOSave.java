package ru.example.bookmarket.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Set;
@Data
@Builder
@Schema
public class BookDTOSave {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(type = "string", example = " ")
    private Long id;
    @Schema(type = "string", example = " ")
    private String name;
    private Set<Long> authorIds;
    private Set<Integer> genreIds;

    private Integer price;
}
