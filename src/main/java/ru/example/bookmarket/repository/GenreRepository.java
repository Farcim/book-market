package ru.example.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.bookmarket.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
