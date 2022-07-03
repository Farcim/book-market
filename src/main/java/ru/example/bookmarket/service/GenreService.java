package ru.example.bookmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.example.bookmarket.genries.Genre;
import ru.example.bookmarket.repository.GenreRepository;
import ru.example.bookmarket.util.Converter;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public List<ru.example.bookmarket.model.Genre> findAllByIds(Collection<Integer> ids) {
        return genreRepository.findAllById(ids);
    }

    public Page<Genre> getAllGenres(Pageable pageable) {
        return genreRepository.findAll(pageable)
                .map(Converter::entityToEnum);
    }

}
