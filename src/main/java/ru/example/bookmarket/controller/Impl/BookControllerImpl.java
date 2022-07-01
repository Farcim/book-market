package ru.example.bookmarket.controller.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.example.bookmarket.controller.BookController;
import ru.example.bookmarket.dto.BookDTO;
import ru.example.bookmarket.dto.BookDTOSave;
import ru.example.bookmarket.service.BookService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class BookControllerImpl implements BookController {
    private final BookService bookService;

    public BookDTO saveBook(@RequestBody BookDTOSave book) {
        return bookService.save(book);
    }

    public List<BookDTO> findByAuthorName(@RequestParam(required = false) String authorName) {
        return bookService.findByAuthorName(authorName);
    }

    public BookDTO findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    public void update(@RequestParam BookDTO book) {
        bookService.update(book);
    }

    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    public Page<BookDTO> getByPage(@PageableDefault Pageable pageable) {
        return bookService.getByPage(pageable);
    }
}


