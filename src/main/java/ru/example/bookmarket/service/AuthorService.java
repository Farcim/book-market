package ru.example.bookmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.bookmarket.model.Author;
import ru.example.bookmarket.repository.AuthorRepository;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    public Author create(Author author){
        return authorRepository.save(author);
    }
}
