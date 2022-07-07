package ru.example.bookmarket.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Set;
@Data
@Builder
@Schema(description = "book entity saver", title = "book saver")
public class BookDTOSave {
    @Schema(type = "int64", example = "null")
    private Long id;
    @Schema(type = "string", example = "Страшный утенок")
    private String name;
    private Set<Long> authorIds;
    private Set<Integer> genreIds;
    @Schema(type = "int32",example = "456")
    private Integer price;
}
