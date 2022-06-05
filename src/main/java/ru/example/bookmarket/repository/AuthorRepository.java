package ru.example.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.bookmarket.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
