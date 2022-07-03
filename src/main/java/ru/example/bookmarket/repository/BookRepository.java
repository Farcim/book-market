package ru.example.bookmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.example.bookmarket.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
     @Query("from Book b join Author a on b.id = a.id where a.name in (:authorName)")
     List<Book> findByAuthorName(String authorName);
}
