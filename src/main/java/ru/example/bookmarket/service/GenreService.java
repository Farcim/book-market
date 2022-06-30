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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public List<Genre> findAllByIds(Collection<Integer> ids) {
        return genreRepository.findAllById(ids).stream()
                .map(Converter::entityToEnum)
                .collect(Collectors.toList());
    }

    public Page<Genre> getGenres(Pageable pageable) {
        return genreRepository.findAll(pageable)
                .map(Converter::entityToEnum);
    }

}
