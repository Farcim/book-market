package ru.example.bookmarket.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private Integer price;
    // add set of Genre and Author class
}
