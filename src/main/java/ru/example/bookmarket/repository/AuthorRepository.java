package ru.example.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<String,Long> {
}
