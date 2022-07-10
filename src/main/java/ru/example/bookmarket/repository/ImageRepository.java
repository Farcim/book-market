package ru.example.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.bookmarket.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
}
