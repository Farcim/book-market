package ru.example.bookmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.bookmarket.exception.GenreNotFoundException;
import ru.example.bookmarket.genries.Genre;
import ru.example.bookmarket.repository.GenreRepository;
import ru.example.bookmarket.util.Converter;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public Genre save(Genre genreEnum) {
        var entity = Converter.convert(genreEnum);
        return Converter.convert(genreRepository.save(entity));
    }

    public Genre findById(int id) {
        return Converter.convert(genreRepository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException(id)));
    }

    public void update(Genre genreEnum) {
        if (genreRepository.existsById(genreEnum.getId())) {
            genreRepository.save(Converter.convert(genreEnum));
        } else {
            throw new GenreNotFoundException(genreEnum.getId());
        }
    }

    public void deleteById(int id) {
        if (genreRepository.existsById(id)) {
            genreRepository.deleteById(id);
        }
        throw new GenreNotFoundException(id);
    }

}
