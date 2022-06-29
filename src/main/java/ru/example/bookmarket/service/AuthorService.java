package ru.example.bookmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.example.bookmarket.dto.AuthorDTO;
import ru.example.bookmarket.exception.AuthorNotFoundException;
import ru.example.bookmarket.model.Author;
import ru.example.bookmarket.repository.AuthorRepository;
import ru.example.bookmarket.util.Converter;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorDTO save(AuthorDTO authorDTO) {
        Author author = Converter.dtoToAuthor(authorDTO);
        return Converter.authorToDTO(authorRepository.save(author));
    }

    public void update(AuthorDTO authorDTO) {
        if (authorRepository.existsById(authorDTO.getId())) {
            authorRepository.save(Converter.dtoToAuthor(authorDTO));
        } else {
            throw new AuthorNotFoundException(authorDTO.getId());
        }
    }

    public void deleteById(Long id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
        } else {
            throw new AuthorNotFoundException(id);
        }
    }

    public AuthorDTO findById(Long id) {
        return Converter.authorToDTO(authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id)));
    }

    public List<Author> findAllBeIds(Collection<Long> ids) {
        return authorRepository.findAllById(ids);
    }
    public Page<AuthorDTO> getByPage(Pageable pageable){
        return authorRepository.findAll(pageable)
                .map(Converter::authorToDTO);
    }
}
