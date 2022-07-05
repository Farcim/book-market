package ru.example.bookmarket.genre;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Genre {
    COMEDIAN(1,"COMEDIAN"),
    DRAMA(2,"DRAMA"),
    ROMAN(3,"ROMAN"),
    ADVENTURE(4,"ADVENTURE");
    private final Integer id;
    private final String name;

}
