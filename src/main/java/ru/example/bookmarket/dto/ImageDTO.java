package ru.example.bookmarket.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageDTO {

    private Long id;
    private String name;
    private Long size;
    private String type;
    private byte[] bytes;
}
