package ru.example.bookmarket.controllerImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.example.bookmarket.controller.GenreController;
import ru.example.bookmarket.genries.Genre;
import ru.example.bookmarket.service.GenreService;

import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GenreControllerImpl implements GenreController {
    private final GenreService genreService;

    public List<Genre> findAllByIds(@RequestParam Collection<Integer> ids) {
        return genreService.findAllByIds(ids);
    }

    public Page<Genre> getGenres(@PageableDefault(size = 5, page = 0) Pageable pageable) {
        return genreService.getGenres(pageable);
    }

}
