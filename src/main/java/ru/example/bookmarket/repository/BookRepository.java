package ru.example.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.example.bookmarket.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
     Book findByAuthor(String author);

     Book findByName(String name);
     Book findByBook(Book book);
}
