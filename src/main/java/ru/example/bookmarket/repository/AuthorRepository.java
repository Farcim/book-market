package ru.example.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.bookmarket.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
