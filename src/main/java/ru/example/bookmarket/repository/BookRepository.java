package ru.example.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.bookmarket.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
     Book findByAuthors(String authors);

     Book findByName(String name);

}
