package ru.example.bookmarket.genries;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Genre {
    COMEDIAN(1,"COMEDIAN"),
    DRAMA(2,"DRAMA"),
    ROMAN(3,"ROMAN"),
    ADVENTURE(4,"ADVENTURE");
    private final int id;
    private final String name;

}
