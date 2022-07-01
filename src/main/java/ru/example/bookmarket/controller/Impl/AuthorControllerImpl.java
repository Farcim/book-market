package ru.example.bookmarket.controller.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.example.bookmarket.controller.AuthorController;
import ru.example.bookmarket.dto.AuthorDTO;
import ru.example.bookmarket.service.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorControllerImpl implements AuthorController {
    private final AuthorService authorService;

    public AuthorDTO save(@RequestBody AuthorDTO authorDTO) {
        return authorService.save(authorDTO);
    }

    public Page<AuthorDTO> getByPage(@PageableDefault(size = 5, page = 0) Pageable pageable) {
        return authorService.getByPage(pageable);
    }

    public AuthorDTO findById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    public void deleteById(@PathVariable Long id) {
        authorService.deleteById(id);
    }

    public void update(@RequestParam AuthorDTO authorDTO) {
        authorService.update(authorDTO);
    }

}
