package ru.example.bookmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.bookmarket.dto.GenreDTO;
import ru.example.bookmarket.exception.GenreNotFoundException;
import ru.example.bookmarket.model.Genre;
import ru.example.bookmarket.repository.GenreRepository;
import ru.example.bookmarket.util.Converter;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreDTO save(GenreDTO genreDTO) {
        Genre genre = Converter.dtoToGenre(genreDTO);
        return Converter.genreToDTO(genreRepository.save(genre));
    }

    public GenreDTO findById(Long id) {
        return Converter.genreToDTO(genreRepository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException(id)));
    }

    public void update(GenreDTO genreDTO) {
        if (genreRepository.existsById(genreDTO.getId())) {
            genreRepository.save(Converter.dtoToGenre(genreDTO));
        } else {
            throw new GenreNotFoundException(genreDTO.getId());
        }
    }

    public void deleteById(Long id) {
        if (genreRepository.existsById(id)) {
            genreRepository.deleteById(id);
        }
        throw new GenreNotFoundException(id);
    }

}
