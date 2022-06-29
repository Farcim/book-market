package ru.example.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.bookmarket.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
