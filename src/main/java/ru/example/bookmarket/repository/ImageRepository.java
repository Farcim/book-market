package ru.example.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.bookmarket.model.Image;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
